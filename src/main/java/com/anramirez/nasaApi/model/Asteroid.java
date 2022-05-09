package com.anramirez.nasaApi.model;

public class Asteroid {

	private String nombre;
	private double diametro;
	private double velocidad;
	private String fecha;
	private String planeta;

	public Asteroid(String nombre, double diametro, double velocidad, String fecha, String planeta) {
		super();
		this.nombre = nombre;
		this.diametro = diametro;
		this.velocidad = velocidad;
		this.fecha = fecha;
		this.planeta = planeta;
	}

	public String getNombre() {
		return nombre;
	}

	public double getDiametro() {
		return diametro;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public String getFecha() {
		return fecha;
	}

	public String getPlaneta() {
		return planeta;
	}

}