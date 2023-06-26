package com.pradiph31.SpeedyDine.entities;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Restaurant {

	@Id
	private Long restaurantId;
	private String name;
	private String address;

	public Restaurant(String name, String address) {
		this.name = name;
		this.address = address;
	}

}
