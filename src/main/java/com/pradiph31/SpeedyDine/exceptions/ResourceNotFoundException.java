package com.pradiph31.SpeedyDine.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -101742142117288857L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}