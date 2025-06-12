package com.ipartek.formacion.pojos;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Persona {
	// VARIABLES DE INSTANCIA
	private String nombre;
	private LocalDate fechaNacimiento;

	// CONSTRUCTORES
	public Persona(String nombre, LocalDate fechaNacimiento) {
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
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
		if(nombre == null) {
			throw new RuntimeException("NO se admite null como nombre");
		}
		
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento != null && fechaNacimiento.isAfter(LocalDate.now())) {
			throw new RuntimeException("No se admiten fechas de nacimiento posteriores a la actual");
		}
		
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int getEdad() {
		return Period.between(fechaNacimiento, LocalDate.now()).getYears();
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
