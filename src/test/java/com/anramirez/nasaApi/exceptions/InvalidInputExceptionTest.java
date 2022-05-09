package com.anramirez.nasaApi.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.anramirez.nasaApi.controller.AsteroidController;
import com.anramirez.nasaApi.service.AsteroidServiceImpl;

@SpringBootTest
class InvalidInputExceptionTest {
	
	@InjectMocks
	private AsteroidController asteroidController;
	
	@Mock
	private AsteroidServiceImpl asteroidService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

	}
	

	@Test
	public void test() throws NullPointerException, InvalidInputException, Exception  {
		InvalidInputException myException = new InvalidInputException(null, "Invalid imput");
		String parametro = "w";
		try {
			this.asteroidController.getHazardousAsteroids(parametro);
		} catch (InvalidInputException e) {
			myException = e;
		}
		assertEquals(myException.getMessage(), "Invalid imput");
	}
	
	@Test
	void testNullPointerException() throws InvalidInputException, Exception {
		NullPointerException myException = null;
		try {
			when(asteroidController.getHazardousAsteroids(null));
		} catch (NullPointerException e) {
			myException = e;
		}
		assertEquals(myException.getMessage(), "Cannot invoke \"String.isEmpty()\" because \"dangerPlanet\" is null");
	}

	@Test
	void testBuildResponseEntity() {
		
	}

}
