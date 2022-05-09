package com.anramirez.nasaApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

public class InvalidInputException extends RuntimeException {

	@SuppressWarnings("unused")
	private HttpStatus status;

	private static final long serialVersionUID = 1L;

	@Nullable
	private String msn;

	public InvalidInputException(HttpStatus status, @Nullable String msn) {
		super("Invalid imput");
		this.status = status;
		this.msn = msn;

	}

}
