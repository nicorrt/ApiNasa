package com.anramirez.nasaApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Método que devuelve un JSON al usuario ante una excepción por ponerl mal el
	 * nombre
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = InvalidInputException.class)
	public ResponseEntity<Object> handleInvalidInputException(InvalidInputException ex) {

		return buildResponseEntity(new ApiErrorResponse(HttpStatus.BAD_REQUEST, "Incorrect input",
				"El nombre del planeta no está en la lista disponible"));
	}

	/**
	 * Método que devuelve un JSON al usuario ante una excepcion
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleException(Exception ex) {
		return buildResponseEntity(
				new ApiErrorResponse(HttpStatus.BAD_REQUEST, "Catch all exception handler", "Ha ocurrido un error"));
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Object> NullPointerException(NullPointerException ex){
		return buildResponseEntity(
				new ApiErrorResponse(HttpStatus.BAD_REQUEST, "Null imput", "No se ha introducido ningún planeta"));
	}

	public ResponseEntity<Object> buildResponseEntity(ApiErrorResponse errorResponse) {
		return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
	}
}