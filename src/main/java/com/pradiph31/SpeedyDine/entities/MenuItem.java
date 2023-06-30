package com.pradiph31.SpeedyDine.entities;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class MenuItem {

	@Id
	private Long itemId;
	private String name;
	private String description;
	private List<String> ingredients;
	private double price;
	private boolean availability;
	private int preparationTime;
	private String image;
	private List<String> allergenInformation;
	private Long restaurantId;

}
