package com.anramirez.nasaApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anramirez.nasaApi.exceptions.InvalidInputException;
import com.anramirez.nasaApi.model.Asteroid;
import com.anramirez.nasaApi.service.AsteroidService;


@RestController
public class AsteroidController {

	@Autowired
	private AsteroidService asteroidService;

	/**
	 * Controlador que busca un planeta y devuelve los 3 posibles asteroides más
	 * peligrosos
	 * 
	 * @param dangerPlanet
	 * @return ResponseEntity<List<Asteroid>>
	 * @throws Exception, InvalidInputException, ResponseStatusException
	 */
	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping("/asteroids")
	public ResponseEntity<List<Asteroid>> getHazardousAsteroids(@RequestParam(name = "Planet", required=false) String dangerPlanet)
			throws NullPointerException, InvalidInputException, Exception {
		if (dangerPlanet.isEmpty()) { throw new NullPointerException("Null Input");
		} else {
			try {
				if (dangerPlanet.equals("Earth")) {
					List<Asteroid> listAsteroid = asteroidService.list3HazardousAsteroids();
					return new ResponseEntity<List<Asteroid>>(listAsteroid, new HttpHeaders(), HttpStatus.OK);
				} else {
					throw new InvalidInputException(HttpStatus.NOT_FOUND,
							"No se ha encontrado datos sobre el planeta: " + dangerPlanet);
				}
			}catch (InvalidInputException e) {
				throw new InvalidInputException(HttpStatus.NOT_FOUND,
						"No se ha encontrado datos sobre el planeta: " + dangerPlanet);
			}catch (NullPointerException e2) {
				throw new NullPointerException("Null Input");
			}
		}

	}

}