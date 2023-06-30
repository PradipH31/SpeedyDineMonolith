package com.pradiph31.SpeedyDine.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.pradiph31.SpeedyDine.entities.MenuItem;

import reactor.core.publisher.Flux;

public interface MenuItemRepository extends ReactiveCrudRepository<MenuItem, Long> {

	Flux<MenuItem> findByRestaurantId(Long restaurantId);

}
