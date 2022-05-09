package com.anramirez.nasaApi.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.anramirez.nasaApi.model.Asteroid;
import com.anramirez.nasaApi.model.NearEarthObject;

public class Utils {

	public Utils() {
		super();
	}

	/**
	 * Método para devolver una lista de asteroides de nuestra clase Asteroid, a
	 * través de la lista de Asteroides (NearEarthObject) de la API externa.
	 * 
	 * @param filterList
	 * @return list
	 */
	public static List<Asteroid> tranformOurClassAsteroid(List<NearEarthObject> filterList) {
		List<Asteroid> list = new ArrayList<>();
		for (NearEarthObject neo : filterList) {
			Asteroid asteroid = new Asteroid(neo.getName(),
					(neo.getEstimatedDiameter().getKilometers().getEstimatedDiameterMax()
							+ neo.getEstimatedDiameter().getKilometers().getEstimatedDiameterMin() / 2),
					neo.getAbsoluteMagnitudeH(), neo.getCloseApproachData().get(0).getCloseApproachDate().toString(),
					neo.getCloseApproachData().get(0).getOrbitingBody().toString());
			list.add(asteroid);
		}
		return list;
	}

	/**
	 * Método para transformar a través de una URL un Objeto JSON en cadena de
	 * carácteres.
	 * 
	 * @param urlParaVisitar
	 * @return
	 * @throws Exception
	 */
	public static String jsonToStringHttpGet(String urlExt) throws Exception {

		StringBuilder resultado = new StringBuilder();

		URL url = new URL(urlExt);

		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");

		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;

		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}

		rd.close();
		return resultado.toString();
	}
}
