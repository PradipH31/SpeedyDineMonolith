package com.pradiph31.SpeedyDine.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

import com.pradiph31.SpeedyDine.entities.Order;
import com.pradiph31.SpeedyDine.repositories.security.UserRepository;
import com.pradiph31.SpeedyDine.services.OrderService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;
	private final UserRepository userRepository;

	@GetMapping("/api/orders")
	public Mono<ResponseEntity<Flux<Order>>> getOrdersOfCurrentUser() {
		return ReactiveSecurityContextHolder.getContext().map(SecurityContext::getAuthentication)
				.map(Authentication::getName).flatMap(userRepository::findByUsername)
				.flatMapMany(orderService::getOrdersByCustomer).collectList()
				.map(orders -> ResponseEntity.ok().body(Flux.fromIterable(orders)));
	}

}
