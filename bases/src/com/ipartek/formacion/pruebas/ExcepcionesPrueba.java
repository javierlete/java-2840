package com.ipartek.formacion.pruebas;

import java.time.DateTimeException;
import java.time.LocalDate;

import com.ipartek.formacion.bibliotecas.Consola;
import com.ipartek.formacion.pojos.Persona;
import com.ipartek.formacion.pojos.PojosException;

public class ExcepcionesPrueba {
	public static void main(String[] args) {
		Persona persona = new Persona();
		
		try {
			int anyo = Consola.leerInteger("Dime el año");
			int mes = Consola.leerInteger("Dime el mes");
			int dia = Consola.leerInteger("Dime el día");
			
			persona.setFechaNacimiento(LocalDate.of(anyo, mes, dia));
		} catch (DateTimeException e) {
			System.out.println("Formato de fecha incorrecto");
		} catch (PojosException e) {
			System.out.println("Se ha detectado una fecha futura");
		} finally {
			System.out.println("Siempre me ejecuto");
		}
		
		System.out.println(persona);
	}
}
