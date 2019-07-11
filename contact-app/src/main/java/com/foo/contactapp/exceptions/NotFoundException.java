package com.foo.contactapp.exceptions;

public class NotFoundException extends RuntimeException{

	private final static String message = "Not Found";
			
	public NotFoundException() {
		super(message);
	}
}
