package com.anramirez.nasaApi.model;

import com.fasterxml.jackson.annotation.*;

public class EstimatedDiameter {
	private Feet kilometers;
	private Feet meters;
	private Feet miles;
	private Feet feet;

	@JsonProperty("kilometers")
	public Feet getKilometers() {
		return kilometers;
	}

	@JsonProperty("kilometers")
	public void setKilometers(Feet value) {
		this.kilometers = value;
	}

	@JsonProperty("meters")
	public void setMeters(Feet value) {
		this.meters = value;
	}

	@JsonProperty("miles")
	public void setMiles(Feet value) {
		this.miles = value;
	}

	@JsonProperty("feet")
	public void setFeet(Feet value) {
		this.feet = value;
	}
}
