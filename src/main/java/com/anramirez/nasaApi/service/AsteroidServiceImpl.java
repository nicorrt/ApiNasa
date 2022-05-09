package com.anramirez.nasaApi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.anramirez.nasaApi.model.Asteroid;
import com.anramirez.nasaApi.model.Converter;
import com.anramirez.nasaApi.model.NearEarthObject;
import com.anramirez.nasaApi.model.Welcome;
import com.anramirez.nasaApi.utils.Utils;


@Service("AsteroidService")
public class AsteroidServiceImpl implements AsteroidService {
	public AsteroidServiceImpl() {
		
	}

	private LocalDate todayDate = LocalDate.now();
	private LocalDate next7Days = todayDate.plusDays(7);

	private String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date=" + todayDate + "&end_date=" + next7Days
			+ "&api_key=zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb";

	@Override
	public List<Asteroid> list3HazardousAsteroids() throws Exception {

		// resultado proviene de un método de utils y que realiza la peticion Http.
		String resultJSON = Utils.jsonToStringHttpGet(url);

		// Deserializa el JSON a objeto
		Welcome welcomeObject = Converter.fromJsonString(resultJSON);

		// Creamos la lista inmutable de la clase Welcome
		List<Welcome> listAsteroids = Collections.singletonList(welcomeObject);

		// Mapeamos de la lista anterior para obtener una coleccion del objeto
		// NearEarthObject.
		Map<String, List<NearEarthObject>> listNEO = listAsteroids.get(0).getNearEarthObjects();

		// Añadimos los valores del mapeo a la colección
		Collection<List<NearEarthObject>> list = listNEO.values();

		List<NearEarthObject> newListNEO = new ArrayList<>();

		// Se crea una nueva lista y se añaden a la nueva lista los valores de la
		// Colección.
		list.forEach(newListNEO::addAll);

		// Acotamos la lista total a solo 3 asteroides por los parámetros indicados,
		// filtro por peligroso y orden da tamaño.
		List<NearEarthObject> list3Harzardous = newListNEO.stream()
				.filter(NearEarthObject::getIsPotentiallyHazardousAsteroid)
				.sorted(Comparator.comparing(NearEarthObject::getAbsoluteMagnitudeH)).limit(3)
				.collect(Collectors.toList());

		// Transformamos los asteroides de la API a través de un método a nuestra clase
		// Asteroide
		List<Asteroid> finalList = Utils.tranformOurClassAsteroid(list3Harzardous);
		return finalList;

	}

}
