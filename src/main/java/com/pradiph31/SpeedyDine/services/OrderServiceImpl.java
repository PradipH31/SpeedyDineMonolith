package com.pradiph31.SpeedyDine.services;

import org.springframework.stereotype.Service;

import com.pradiph31.SpeedyDine.entities.Order;
import com.pradiph31.SpeedyDine.entities.security.User;
import com.pradiph31.SpeedyDine.repositories.CustomerRepository;
import com.pradiph31.SpeedyDine.repositories.OrderRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final CustomerRepository customerRepository;

	@Override
	public Flux<Order> getOrdersByCustomer(User user) {
		return customerRepository.findByUserId(user.getUserId())
				.flatMapMany(customer -> orderRepository.findByCustomerId(customer.getCustomerId()));
	}

}
