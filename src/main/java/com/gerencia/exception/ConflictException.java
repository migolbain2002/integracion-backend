package com.gerencia.exception;

public class ConflictException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConflictException() {
		super();
	}

	public ConflictException(String message) {
		super(message);
	}
}
