package com.ipartek.formacion.pruebas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.ipartek.formacion.bibliotecas.Consola.*;

public class ConsolaPruebas {
	public static void main(String[] args) {
		LocalDate fecha = leerLocalDate("Fecha actual", LocalDate.of(2000, 1, 1), LocalDate.of(2030, 1, 1));
		
		System.out.println(fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}
}
