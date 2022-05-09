package com.anramirez.nasaApi.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.anramirez.nasaApi.DatosPruebas;
import com.anramirez.nasaApi.model.Asteroid;
import com.anramirez.nasaApi.service.AsteroidService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AsteroidController.class)
class AsteroidControllerTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	@MockBean
	private AsteroidService asteroidService;	
	
	ObjectMapper objectMapper;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		objectMapper = new ObjectMapper();
	}

	@Test
	void testGetHazardousAsteroids() throws Exception {
		List<Asteroid> asteroids = Arrays.asList(DatosPruebas.crearAsteroid01().orElseThrow(), DatosPruebas.crearAsteroid02().orElseThrow(), DatosPruebas.crearAsteroid03().orElseThrow());
		
		when(asteroidService.list3HazardousAsteroids()).thenReturn(asteroids);
		
		mockMVC.perform(get("/asteroids?Planet=Earth").contentType(MediaType.APPLICATION_JSON))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].nombre").value("Asteroide01"))
		.andExpect(jsonPath("$[1].nombre").value("Asteroide02"))
		.andExpect(jsonPath("$[2].nombre").value("Asteroide03"))
		.andExpect(jsonPath("$[0].diametro").value(1.0))
		.andExpect(jsonPath("$[1].diametro").value(1.0))
		.andExpect(jsonPath("$[2].diametro").value(1.0))
		.andExpect(jsonPath("$[0].velocidad").value(1.0))
		.andExpect(jsonPath("$[1].velocidad").value(1.0))
		.andExpect(jsonPath("$[2].velocidad").value(1.0))
		.andExpect(jsonPath("$[0].fecha").value("2022-04-18"))
		.andExpect(jsonPath("$[1].fecha").value("2022-04-18"))
		.andExpect(jsonPath("$[2].fecha").value("2022-04-18"))
		.andExpect(jsonPath("$[0].planeta").value("EARTH"))
		.andExpect(jsonPath("$[1].planeta").value("EARTH"))
		.andExpect(jsonPath("$[2].planeta").value("EARTH"))
		.andExpect(jsonPath("$", hasSize(3)))
		.andExpect(content().json(objectMapper.writeValueAsString(asteroids)));
		
		verify(asteroidService).list3HazardousAsteroids();

	}

}
