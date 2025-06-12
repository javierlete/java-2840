package com.ipartek.formacion.pruebas;

import java.time.LocalDate;

import com.ipartek.formacion.pojos.Local;
import com.ipartek.formacion.pojos.Persona;

public class LocalPrueba {
	public static void main(String[] args) {
		var responsable = new Persona("Javier", LocalDate.of(2020, 6, 12));
		
		Local local = new Local("Ipartek", responsable);
		
		local.entrar(new Persona("Pepe", LocalDate.of(1995, 2, 3)));
		local.entrar(new Persona("Juan", LocalDate.of(2010, 2, 1)));
		local.entrar(responsable);
//		local.entrar(null);
//		local.entrar(new Persona("Otro", null));
		
		System.out.println(local);
		
		System.out.println(local.getVisitantes());
		
		for(var visitante: local.getVisitantes()) {
			System.out.println(visitante.getNombre());
		}
	}
}
