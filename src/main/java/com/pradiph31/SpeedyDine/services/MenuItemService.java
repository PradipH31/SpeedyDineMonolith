package com.pradiph31.SpeedyDine.services;

import com.pradiph31.SpeedyDine.entities.MenuItem;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MenuItemService {

	public Mono<MenuItem> save(Mono<MenuItem> menuItemMono);

	public Mono<MenuItem> findById(Long id);

	public Flux<MenuItem> findByRestaurantId(Long id);
}
