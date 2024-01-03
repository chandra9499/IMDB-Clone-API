package com.example.imdb.exception;

public class MovieNotFoundException extends RuntimeException {

	private String message;
	public MovieNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}