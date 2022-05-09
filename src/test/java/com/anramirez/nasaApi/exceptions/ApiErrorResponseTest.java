package com.anramirez.nasaApi.exceptions;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ApiErrorResponse.class)
class ApiErrorResponseTest {
	
	@Autowired
	private MockMvc mockMVC;

	@Mock
	private GlobalExceptionHandler globalException;

	private InvalidInputException apiResponseNull;

	@MockBean
	private ApiErrorResponse apiResponseInvalid;
	

	private ApiErrorResponse apiResponseInvalid2;	
	
	ObjectMapper objectMapper;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		objectMapper = new ObjectMapper();
		
		apiResponseInvalid = new ApiErrorResponse(HttpStatus.BAD_REQUEST, "Incorrect input",
				"El nombre del planeta no está en la lista disponible");
		apiResponseInvalid2 = new ApiErrorResponse(HttpStatus.BAD_REQUEST, "Incorrect input", apiResponseNull);
	}

	@Test
	void testApiErrorNullPointer() {
		apiResponseNull = new InvalidInputException(HttpStatus.BAD_REQUEST, "Null imput");
		ResponseEntity<Object> generico = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		when(globalException.handleInvalidInputException(apiResponseNull)).thenReturn(generico);
		assertNotNull(apiResponseNull);
	}
	


}
