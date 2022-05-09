package com.anramirez.nasaApi.model;

import com.fasterxml.jackson.annotation.*;

public class RelativeVelocity {
	private String kilometersPerSecond;
	private String kilometersPerHour;
	private String milesPerHour;

	@JsonProperty("kilometers_per_second")
	public void setKilometersPerSecond(String value) {
		this.kilometersPerSecond = value;
	}

	@JsonProperty("kilometers_per_hour")
	public void setKilometersPerHour(String value) {
		this.kilometersPerHour = value;
	}

	@JsonProperty("miles_per_hour")
	public void setMilesPerHour(String value) {
		this.milesPerHour = value;
	}
}
