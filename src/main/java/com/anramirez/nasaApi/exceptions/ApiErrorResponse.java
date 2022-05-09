package com.anramirez.nasaApi.exceptions;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse {
	private HttpStatus status;
	private String message;
	private String ex;

	public ApiErrorResponse(HttpStatus status, String message, String string) {
		this.status = status;
		this.message = message;
		this.ex = string;
	}

	public ApiErrorResponse(HttpStatus status, String message, Exception ex) {
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getEx() {
		return ex;
	}

	public void setEx(String ex) {
		this.ex = ex;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "ApiErrorResponse{" + "status=" + status + ", message=" + message + '}';
	}
}
