package com.pradiph31.SpeedyDine.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.pradiph31.SpeedyDine.entities.Order;

import reactor.core.publisher.Flux;

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {

	public Flux<Order> findByCustomerId(Long customerId);
	
}
