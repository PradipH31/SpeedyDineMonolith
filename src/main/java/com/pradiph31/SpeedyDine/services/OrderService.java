package com.pradiph31.SpeedyDine.services;

import com.pradiph31.SpeedyDine.entities.Order;
import com.pradiph31.SpeedyDine.entities.security.User;

import reactor.core.publisher.Flux;

public interface OrderService {

	Flux<Order> getOrdersByCustomer(User user);
	
}
