package com.pradiph31.SpeedyDine.entities;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Customer {
	@Id
	private Long customerId;

	private String address;

	private String phoneNumber;

	private Long userId;
}
