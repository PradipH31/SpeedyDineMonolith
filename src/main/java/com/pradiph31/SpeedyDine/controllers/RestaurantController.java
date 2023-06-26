package com.pradiph31.SpeedyDine.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

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
	public Flux<Restaurant> getAllRestaurants() {
		return restaurantService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Restaurant> getRestaurantById(@PathVariable("id") Long id) {
		return restaurantService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantService.save(new Restaurant(restaurant.getName(), restaurant.getAddress()));
	}

}
