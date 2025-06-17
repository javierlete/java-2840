package com.ipartek.formacion.pruebas;

import java.time.LocalDate;

import com.ipartek.formacion.pojos.Local;
import com.ipartek.formacion.pojos.Persona;
import com.ipartek.formacion.pojos.Trabajador;

public class HerenciaPruebas {
	public static void main(String[] args) {
		Trabajador trabajador = new Trabajador("Javier", "Lete", LocalDate.of(2000, 1, 2), "12345678Z",
				"1234-1234-1234-1234");

		System.out.println(trabajador);

		Persona persona = trabajador;

//		persona.setFechaNacimiento(LocalDate.of(2010, 1, 2));

		Object objeto = persona;

		System.out.println(objeto);

//		System.out.println(persona.getApellidos());

		if (objeto instanceof Trabajador trabajador2) {
			System.out.println(trabajador2);
		} else {
			System.out.println("No es un trabajador");
		}
		
		Persona personaPuro = new Persona();

		if (personaPuro instanceof Trabajador) {
			Trabajador trabajadorFalso = (Trabajador) personaPuro;
			System.out.println(trabajadorFalso);
		} else {
			System.out.println("No es un trabajador");
		}

		Local local = new Local("Pruebas", trabajador);

//		local.getResponsable().setFechaNacimiento(LocalDate.of(2010, 1, 2));

		Persona responsable = local.getResponsable();

		Trabajador trabajadorResponsable = (Trabajador) responsable;

		System.out.println(trabajadorResponsable.getDni());
	}
}
