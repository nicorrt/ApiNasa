package com.anramirez.nasaApi;

import java.util.Optional;

import com.anramirez.nasaApi.model.Asteroid;


public class DatosPruebas {

	public static Optional<Asteroid> crearAsteroid01() {
		return Optional.of(new Asteroid("Asteroide01", 1.0, 1.0, "2022-04-18", "EARTH"));
	}

	public static Optional<Asteroid> crearAsteroid02() {
		return Optional.of(new Asteroid("Asteroide02", 1.0, 1.0, "2022-04-18", "EARTH"));
	}

	public static Optional<Asteroid> crearAsteroid03() {
		return Optional.of(new Asteroid("Asteroide03", 1.0, 1.0, "2022-04-18", "EARTH"));
	}
}
