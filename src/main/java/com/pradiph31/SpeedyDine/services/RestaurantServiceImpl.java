package com.pradiph31.SpeedyDine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pradiph31.SpeedyDine.entities.Restaurant;
import com.pradiph31.SpeedyDine.exceptions.ResourceNotFoundException;
import com.pradiph31.SpeedyDine.repositories.RestaurantRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	public RestaurantRepository restaurantRepository;

	@Override
	public Mono<Restaurant> save(Mono<Restaurant> restaurantMono) {
		return restaurantMono.flatMap(restaurantRepository::save);
	}

	@Override
	public Mono<Restaurant> findById(Long id) {
		return restaurantRepository.findById(id);
	}

	@Override
	public Flux<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}

}
