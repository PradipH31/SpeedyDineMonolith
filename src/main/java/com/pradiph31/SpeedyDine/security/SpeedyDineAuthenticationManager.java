package com.pradiph31.SpeedyDine.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class SpeedyDineAuthenticationManager implements ReactiveAuthenticationManager {

	private final ReactiveUserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;

	@Override
	public Mono<Authentication> authenticate(Authentication authentication) {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		return userDetailsService.findByUsername(username)
				.filter(userDetails -> passwordEncoder.matches(password, userDetails.getPassword()))
				.switchIfEmpty(Mono.error(new BadCredentialsException("Invalid credentials")))
				.map(userDetails -> new UsernamePasswordAuthenticationToken(userDetails, password,
						userDetails.getAuthorities()));
	}

}
