package com.anramirez.nasaApi.exceptions;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.anramirez.nasaApi.controller.AsteroidController;
import com.anramirez.nasaApi.model.Asteroid;

class GlobalExceptionHandlerTest {
	
	@Mock
	ApiErrorResponse apiErrorResponse;
	
	@Mock
	AsteroidController asteroidController;
	
	@Mock
	InvalidInputException exception;
	
	private static final String nombre = "w";

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

		asteroidController = new AsteroidController();

	}

	@Test
	void testHandleInvalidInputException() throws NullPointerException, Exception {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<List<Asteroid>> responseEntity = new ResponseEntity<List<Asteroid>>(
		    header, 
		    HttpStatus.BAD_REQUEST
		);
		
		
		ApiErrorResponse api = new ApiErrorResponse(HttpStatus.BAD_REQUEST, "Incorrect input",
				"El nombre del planeta no está en la lista disponible");
		


		doThrow(new InvalidInputException(HttpStatus.NOT_FOUND,
				"No se ha encontrado datos sobre el planeta: " + nombre)).when(asteroidController.getHazardousAsteroids("Earth"));
		
	}

	@Test
	void testHandleException() {
		fail("Not yet implemented");
	}

	@Test
	void testNullPointerException() {
		fail("Not yet implemented");
	}

	@Test
	void testBuildResponseEntity() {
		fail("Not yet implemented");
	}
	
	public ResponseEntity<Object> buildResponseEntity(ApiErrorResponse errorResponse) {
		return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
	}

}
