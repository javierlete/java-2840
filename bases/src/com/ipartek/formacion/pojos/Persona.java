package com.ipartek.formacion.pojos;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {
	// VARIABLES DE INSTANCIA
	private String nombre;
	private LocalDate fechaNacimiento;

	// CONSTRUCTORES
	public Persona(String nombre, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Persona() {
		
	}
	
	// Constructor de copia
	public Persona(Persona persona) {
		this(persona.nombre, persona.fechaNacimiento);
	}
	
	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	// Source / Generate hashCode() and equals()...
	@Override
	public int hashCode() {
		return Objects.hash(fechaNacimiento, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	
}
