package com.pradiph31.SpeedyDine.controllers.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pradiph31.SpeedyDine.entities.security.User;
import com.pradiph31.SpeedyDine.exceptions.EmailAlreadyExistsException;
import com.pradiph31.SpeedyDine.exceptions.UsernameAlreadyExistsException;
import com.pradiph31.SpeedyDine.repositories.security.UserRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UserAccountController {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;

	@PostMapping("/sign-up")
	public Mono<ResponseEntity<String>> signUp(@RequestBody User user) {
		return userRepository.findByUsername(user.getUsername())
				.flatMap((u) -> Mono.error(new UsernameAlreadyExistsException(
						"There is already a user with the username " + u.getUsername())))
				.then(userRepository.findByEmail(user.getEmail()))
				.flatMap((u) -> Mono.error(
						new EmailAlreadyExistsException("There is already a user with the email " + u.getEmail())))
				.switchIfEmpty(Mono.defer(() -> {
					String hashedPassword = passwordEncoder.encode(user.getPassword());
					user.setPassword(hashedPassword);
					return userRepository.save(user);
				})).map(u -> ResponseEntity.status(HttpStatus.CREATED).body("Sign up successful")).onErrorResume(e -> {
					if (e instanceof UsernameAlreadyExistsException || e instanceof EmailAlreadyExistsException) {
						return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()));
					} else {
						return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
								.body("An exception occurred due to " + e.getMessage()));
					}
				});
	}

	@GetMapping("/userinfo")
	public Mono<ResponseEntity<?>> getUserDetails(Authentication authentication) {
		return userRepository.findByUsername(authentication.getName())
				.switchIfEmpty(Mono.error(() -> new UsernameNotFoundException("Username not found")))
				.map(user -> ResponseEntity.ok(user));
	}

}
