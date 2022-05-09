package com.anramirez.nasaApi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.anramirez.nasaApi.controller.AsteroidController;
import com.anramirez.nasaApi.model.Asteroid;


@WebMvcTest(value=AsteroidController.class)
public class AsteroidServiceImplTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AsteroidServiceImpl asteroidServiceImpl;	
	
	@InjectMocks
	private AsteroidServiceImpl asteroidService;
	
	@Mock
	private AsteroidController asteroidController;
	
	private ResponseEntity<List<Asteroid>> listAsteroid;

	
	@BeforeEach
	public void setup(){
		MockitoAnnotations.openMocks(this);

		
	}
	
	@Test
	public void testList3HazardousAsteroids() throws Exception {
		
		List<Asteroid> list = new ArrayList<Asteroid>();
		
		
		Asteroid asteroid1 = new Asteroid("Asteroide01", 1.0, 1.0, "2022-04-18", "EARTH");
		Asteroid asteroid2 = new Asteroid("Asteroide01", 1.0, 1.0, "2022-04-18", "EARTH");
		Asteroid asteroid3 = new Asteroid("Asteroide01", 1.0, 1.0, "2022-04-18", "EARTH");
		
		list.add(asteroid3);
		list.add(asteroid2);
		list.add(asteroid1);
		
		when(asteroidController.getHazardousAsteroids("Earth")).thenReturn(listAsteroid);
		when(asteroidServiceImpl.list3HazardousAsteroids()).thenReturn(list);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/asteroids?Planet=Earth").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		//test
		String expected = "[{\"nombre\":\"Asteroide01\",\"diametro\":1.0,\"velocidad\":1.0,\"fecha\":\"2022-04-18\",\"planeta\":\"EARTH\"},{\"nombre\":\"Asteroide01\",\"diametro\":1.0,\"velocidad\":1.0,\"fecha\":\"2022-04-18\",\"planeta\":\"EARTH\"},{\"nombre\":\"Asteroide01\",\"diametro\":1.0,\"velocidad\":1.0,\"fecha\":\"2022-04-18\",\"planeta\":\"EARTH\"}]";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		List<Asteroid> asteroidList = asteroidServiceImpl.list3HazardousAsteroids();

		assertEquals(3, asteroidList.size());
		assertEquals(list, asteroidList);

		/**
		String respuestaJSON = "{'nombre':'467460 (2006 JF42)','diametro':1.05119154675,'velocidad':19.2,'fecha':'2022-05-09','planeta':'EARTH'},{'nombre':'416801 (2005 GC120)','diametro':0.85444056755,'velocidad':19.65,'fecha':'2022-05-09','planeta':'EARTH'},{'nombre':'(2016 XM)','diametro':0.7615209574499999,'velocidad':19.9,'fecha':'2022-05-10','planeta':'EARTH'}";
		when(Utils.jsonToStringHttpGet(anyString())).thenReturn(respuestaJSON);
		asteroidServiceImpl.list3HazardousAsteroids();
	*/
	}
	
	@Test
	void list3HazardousAsteroids() throws Exception {
		String respuestaJSON = "{'nombre':'467460 (2006 JF42)','diametro':1.05119154675,'velocidad':19.2,'fecha':'2022-05-09','planeta':'EARTH'},{'nombre':'416801 (2005 GC120)','diametro':0.85444056755,'velocidad':19.65,'fecha':'2022-05-09','planeta':'EARTH'},{'nombre':'(2016 XM)','diametro':0.7615209574499999,'velocidad':19.9,'fecha':'2022-05-10','planeta':'EARTH'}";
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<List<Asteroid>> responseEntity = new ResponseEntity<List<Asteroid>>(
		    header, 
		    HttpStatus.OK
		);
		when(asteroidController.getHazardousAsteroids("Earth")).thenReturn(responseEntity);
		assertNotNull(asteroidService.list3HazardousAsteroids());
		
	}
	
}
