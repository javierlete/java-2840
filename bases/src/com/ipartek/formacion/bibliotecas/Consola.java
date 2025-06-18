package com.ipartek.formacion.bibliotecas;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Consola {
	private static final Scanner SC = new Scanner(System.in);
	
	public static String leerString(String mensaje) {
		System.out.print(mensaje + ": ");
		
		return SC.nextLine();
	}
	
	public static int leerInt(String mensaje) {
		return leerInt(mensaje, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static int leerInt(String mensaje, int minimo) {
		return leerInt(mensaje, minimo, Integer.MAX_VALUE);
	}

	public static int leerInt(String mensaje, int minimo, int maximo) {
		boolean correcto = false;
		int valor = 0;
		
		do {
			try {
				valor = Integer.parseInt(leerString(mensaje));
				
				if(valor >= minimo && valor <= maximo) {
					correcto = true;
				} else {
					System.out.println("El valor debe estar entre " + minimo + " y " + maximo);
				} 
			} catch (NumberFormatException e) {
				System.out.println("El número no es correcto");
				System.out.println(e.getMessage());
			} 
		} while (!correcto);
		
		return valor;
	}
	
	public static double leerDouble(String mensaje) {
		return leerDouble(mensaje, Double.MIN_NORMAL, Double.MAX_VALUE);
	}
	
	public static double leerDouble(String mensaje, double minimo) {
		return leerDouble(mensaje, minimo, Double.MAX_VALUE);
	}
	
	public static double leerDouble(String mensaje, double minimo, double maximo) {
		boolean correcto = false;
		double valor = 0;
		
		do {
			try {
				valor = Double.parseDouble(leerString(mensaje));
				
				if(valor >= minimo && valor <= maximo) {
					correcto = true;
				} else {
					System.out.println("El valor debe estar entre " + minimo + " y " + maximo);
				}
			} catch (NumberFormatException e) {
				System.out.println("El número no es correcto");
				System.out.println(e.getMessage());
			} 
		} while (!correcto);
		
		return valor;
	}
	
	public static LocalDate leerFecha() {
		return leerFecha("Introduce una fecha (formato: AAAA-MM-DD)");
	}
	
	public static LocalDate leerFecha(String mensaje) {
		return leerFecha(mensaje, LocalDate.MIN, LocalDate.MAX);
	}
	
	public static LocalDate leerFecha(String mensaje, LocalDate minimo, LocalDate maximo) {
		boolean correcto = false;
		LocalDate fecha = null;
		
		do {
			try {
				String fechaStr = leerString(mensaje);
				fecha = LocalDate.parse(fechaStr);
				
				if(fecha.isAfter(minimo) && fecha.isBefore(maximo)) {
					correcto = true;
				} else {
					System.out.println("La fecha debe estar entre " + minimo + " y " + maximo);
				}
			} catch (DateTimeParseException e) {
				System.out.println("La fecha no es correcta");
				System.out.println(e.getMessage());
			} 
		} while (!correcto);
		
		return fecha;
	}
	
	public static void cerrarConsola() {
		SC.close();
	}
}
