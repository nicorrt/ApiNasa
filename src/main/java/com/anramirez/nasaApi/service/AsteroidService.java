package com.anramirez.nasaApi.service;

import java.util.List;

import com.anramirez.nasaApi.model.Asteroid;


public interface AsteroidService {
	
	public List<Asteroid> list3HazardousAsteroids()  throws Exception;
	
}
