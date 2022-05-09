package com.anramirez.nasaApi.model;

import com.fasterxml.jackson.annotation.*;

public class WelcomeLinks {
	private String next;
	private String prev;
	private String self;

	@JsonProperty("next")
	public void setNext(String value) {
		this.next = value;
	}

	@JsonProperty("prev")
	public void setPrev(String value) {
		this.prev = value;
	}

	@JsonProperty("self")
	public void setSelf(String value) {
		this.self = value;
	}
}
