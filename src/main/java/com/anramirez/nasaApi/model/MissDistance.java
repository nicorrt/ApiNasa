package com.anramirez.nasaApi.model;

import com.fasterxml.jackson.annotation.*;

public class MissDistance {
	private String astronomical;
	private String lunar;
	private String kilometers;
	private String miles;

	@JsonProperty("astronomical")
	public void setAstronomical(String value) {
		this.astronomical = value;
	}

	@JsonProperty("lunar")
	public void setLunar(String value) {
		this.lunar = value;
	}

	@JsonProperty("kilometers")
	public void setKilometers(String value) {
		this.kilometers = value;
	}

	@JsonProperty("miles")
	public void setMiles(String value) {
		this.miles = value;
	}
}
