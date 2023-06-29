package com.pradiph31.SpeedyDine.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pradiph31.SpeedyDine.entities.Restaurant;
import com.pradiph31.SpeedyDine.services.RestaurantService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Mono<ResponseEntity<Flux<Restaurant>>> getAllRestaurants() {
		System.out.println("get all");
		return Mono.just(ResponseEntity.ok().body(restaurantService.findAll()));
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<ResponseEntity<Restaurant>> getRestaurantById(@PathVariable("id") Long id) {
		return restaurantService.findById(id).map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<ResponseEntity<Restaurant>> createRestaurant(@RequestBody Mono<Restaurant> restaurantMono) {
		return restaurantService.save(restaurantMono).map(savedRestaurant -> ResponseEntity
				.created(URI.create("/restaurants/" + savedRestaurant.getRestaurantId())).body(savedRestaurant));
	}

}
