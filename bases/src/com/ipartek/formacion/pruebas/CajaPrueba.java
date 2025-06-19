package com.ipartek.formacion.pruebas;

import com.ipartek.formacion.pojos.Caja;
import com.ipartek.formacion.pojos.Persona;

public class CajaPrueba {
	public static void main(String[] args) {
		var caja = new Caja<String>("Texto guardado en la caja");
		
		System.out.println(caja);
		
		caja.setContenido("Otro");
		
		System.out.println(caja);
		
		String contenido = caja.getContenido();
		
		System.out.println(contenido);
		
		var cajaPersona = new Caja<Persona>();
		
		cajaPersona.setContenido(new Persona());
		
		Persona p = cajaPersona.getContenido();
		
		System.out.println(p);
	}
}
