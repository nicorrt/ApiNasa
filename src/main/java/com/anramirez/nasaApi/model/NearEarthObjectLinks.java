package com.anramirez.nasaApi.model;

import com.fasterxml.jackson.annotation.*;

public class NearEarthObjectLinks {
	private String self;

	@JsonProperty("self")
	public void setSelf(String value) {
		this.self = value;
	}
}
