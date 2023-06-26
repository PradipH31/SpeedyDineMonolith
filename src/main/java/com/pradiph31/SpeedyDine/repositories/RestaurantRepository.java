package com.pradiph31.SpeedyDine.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.pradiph31.SpeedyDine.entities.Restaurant;

public interface RestaurantRepository extends ReactiveCrudRepository<Restaurant, Long>{

}
