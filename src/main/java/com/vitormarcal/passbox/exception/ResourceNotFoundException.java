package com.vitormarcal.passbox.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Long id) {
		super(String.format("recurso %s não foi encontrado", id));
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	

}
