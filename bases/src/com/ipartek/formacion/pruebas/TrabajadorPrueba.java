package com.ipartek.formacion.pruebas;

import java.time.LocalDate;

import com.ipartek.formacion.pojos.Local;
import com.ipartek.formacion.pojos.Trabajador;

public class TrabajadorPrueba {
	public static void main(String[] args) {
		Trabajador trabajador = new Trabajador("Javier", "Lete", LocalDate.of(2000, 1, 2), "12345678Z", "1234-1234-1234-1234");
		
		System.out.println(trabajador);
		
		Local local = new Local("Curso", trabajador);
		
		System.out.println(local);
		
		local.entrar(trabajador);
		
		System.out.println(local.getVisitantes());
	}
}
