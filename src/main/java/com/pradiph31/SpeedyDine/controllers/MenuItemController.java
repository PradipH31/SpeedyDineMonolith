package com.pradiph31.SpeedyDine.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pradiph31.SpeedyDine.entities.MenuItem;
import com.pradiph31.SpeedyDine.services.MenuItemService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MenuItemController {

	@Autowired
	private MenuItemService menuItemService;

	@GetMapping("/api/menuitems/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<ResponseEntity<MenuItem>> getMenuItemById(@PathVariable("id") Long id) {
		return menuItemService.findById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@GetMapping("/api/restaurants/{restaurantId}/menuitems")
	public Mono<ResponseEntity<Flux<MenuItem>>> getMenuItemsByRestaurantId(@PathVariable Long restaurantId) {
		return menuItemService.findByRestaurantId(restaurantId).collectList().flatMap(menuItems -> {
			if (menuItems.isEmpty()) {
				return Mono.just(ResponseEntity.notFound().build());
			} else {
				return Mono.just(ResponseEntity.ok().body(Flux.fromIterable(menuItems)));
			}
		});
	}

	@PostMapping("/api/menuitems")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<ResponseEntity<MenuItem>> createMenuItem(@RequestBody Mono<MenuItem> menuItemMono) {
		return menuItemService.save(menuItemMono).map(savedMenuItem -> ResponseEntity
				.created(URI.create("/menuItems/" + savedMenuItem.getItemId())).body(savedMenuItem));
	}

}
