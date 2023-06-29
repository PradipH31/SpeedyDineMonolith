package com.pradiph31.SpeedyDine.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.pradiph31.SpeedyDine.entities.security.User;
import com.pradiph31.SpeedyDine.repositories.security.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class SpeedyDineUserDetailsService implements ReactiveUserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Mono<UserDetails> findByUsername(String username) {
		return userRepository.findByUsername(username)
				.map(user -> new User(user.getUsername(), user.getPassword(), user.getEmail(), user.getRoles()));
	}

}
