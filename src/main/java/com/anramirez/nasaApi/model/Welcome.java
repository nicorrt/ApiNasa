package com.anramirez.nasaApi.model;

import com.fasterxml.jackson.annotation.*;
import java.util.List;
import java.util.Map;

public class Welcome {
	private WelcomeLinks links;
	private long elementCount;
	private Map<String, List<NearEarthObject>> nearEarthObjects;

	@JsonProperty("links")
	public void setLinks(WelcomeLinks value) {
		this.links = value;
	}

	@JsonProperty("element_count")
	public void setElementCount(long value) {
		this.elementCount = value;
	}

	@JsonProperty("near_earth_objects")
	public Map<String, List<NearEarthObject>> getNearEarthObjects() {
		return nearEarthObjects;
	}

	@JsonProperty("near_earth_objects")
	public void setNearEarthObjects(Map<String, List<NearEarthObject>> value) {
		this.nearEarthObjects = value;
	}
}
