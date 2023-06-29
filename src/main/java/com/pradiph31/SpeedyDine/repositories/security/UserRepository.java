package com.pradiph31.SpeedyDine.repositories.security;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.pradiph31.SpeedyDine.entities.security.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends R2dbcRepository<User, Long> {
	Mono<User> findByUsername(String username);
	Mono<User> findByEmail(String email);
}
