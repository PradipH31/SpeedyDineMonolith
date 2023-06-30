package com.pradiph31.SpeedyDine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pradiph31.SpeedyDine.entities.MenuItem;
import com.pradiph31.SpeedyDine.repositories.MenuItemRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MenuItemSericeImpl implements MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public Mono<MenuItem> save(Mono<MenuItem> menuItemMono) {
		return menuItemMono.flatMap(menuItemRepository::save);
	}

	@Override
	public Mono<MenuItem> findById(Long id) {
		return menuItemRepository.findById(id);
	}

	@Override
	public Flux<MenuItem> findByRestaurantId(Long id) {
		return menuItemRepository.findByRestaurantId(id);
	}

}
