package com.ipartek.formacion.ejemplos;

import java.time.LocalDate;

public class ConversionesAString {
	public static void main(String[] args) {
		int i = 5;
		
		String texto = String.valueOf(i);
		
		System.out.println(texto);
		
		LocalDate ld = LocalDate.now();
		
		texto = ld.toString();
		
		System.out.println(texto);
	}
}
