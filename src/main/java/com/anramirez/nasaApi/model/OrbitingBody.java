package com.anramirez.nasaApi.model;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum OrbitingBody {
	EARTH, VENUS, MERCURY, MARS, JUPITER, SATURN, URANUS, NEPTUNE;


	@JsonCreator
	public static OrbitingBody forValue(String value) throws IOException {
		if (value.equals("Earth"))
			return EARTH;

		throw new IOException("Cannot deserialize OrbitingBody");
	}
}
