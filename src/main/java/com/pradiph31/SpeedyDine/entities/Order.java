package com.pradiph31.SpeedyDine.entities;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(name = "orders")
public class Order {
	@Id
	private Long orderId;

	private List<String> menuItemIds;

	private String customerId;

	private LocalDate orderDate;

	private double totalPrice;

	private boolean isCompleted;

	private String deliveryAddress;

	private String specialInstructions;

}