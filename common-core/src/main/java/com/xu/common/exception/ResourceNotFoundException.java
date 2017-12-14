package com.xu.common.exception;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3126376889983681730L;

	public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
