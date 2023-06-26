package com.pradiph31.SpeedyDine.services;

import com.pradiph31.SpeedyDine.entities.Restaurant;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RestaurantService {
	public Mono<Restaurant> save(Restaurant restaurant);

	public Mono<Restaurant> findById(Long id);

	public Flux<Restaurant> findAll();
}
