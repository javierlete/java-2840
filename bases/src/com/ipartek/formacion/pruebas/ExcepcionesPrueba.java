package com.ipartek.formacion.pruebas;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

import com.ipartek.formacion.pojos.Persona;
import com.ipartek.formacion.pojos.PojosException;

public class ExcepcionesPrueba {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Persona persona = new Persona();
		
		try {
			boolean correcto = false;
			int anyo = 0;
			
			do {
				try {
					System.out.print("Dime el año: ");
					anyo = Integer.parseInt(sc.nextLine());
					correcto = true;
				} catch (NumberFormatException e) {
					System.out.println("El año es incorrecto");
				} 
			} while (!correcto);
			
			System.out.print("Dime el mes: ");
			int mes = Integer.parseInt(sc.nextLine());
			
			System.out.print("Dime el día: ");
			int dia = Integer.parseInt(sc.nextLine());
			
			persona.setFechaNacimiento(LocalDate.of(anyo, mes, dia));
		} catch (DateTimeException e) {
			System.out.println("Formato de fecha incorrecto");
		} catch (PojosException e) {
			System.out.println("Se ha detectado una fecha futura");
		} finally {
			System.out.println("Siempre me ejecuto");
			sc.close();
		}
		
		System.out.println(persona);
	}
}
