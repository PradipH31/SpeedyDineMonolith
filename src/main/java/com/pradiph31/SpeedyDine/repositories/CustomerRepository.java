package com.pradiph31.SpeedyDine.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.pradiph31.SpeedyDine.entities.Customer;

import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {

	Mono<Customer> findByUserId(Long userId);

}
