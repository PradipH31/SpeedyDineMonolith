package com.pradiph31.SpeedyDine.entities;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Restaurant {

	@Id
	private Long restaurantId;
	private String name;
	private String address;
	private String phoneNumber;
	private String email;
	private String openingHours;
	private String cuisineType;
	private double deliveryRadius;
	private double averageRating;
	private String owner;
	private String website;

}
