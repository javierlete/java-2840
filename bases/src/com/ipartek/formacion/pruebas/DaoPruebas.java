package com.ipartek.formacion.pruebas;

import com.ipartek.formacion.daos.Dao;
import com.ipartek.formacion.daos.DaoPersonaFichero;
import com.ipartek.formacion.pojos.Persona;

public class DaoPruebas {
	public static void main(String[] args) {
		Dao<Persona> dao = new DaoPersonaFichero("fichero.dat");
		
		dao.insertar(new Persona());
		dao.insertar(new Persona("Javier"));
		
		for(var p: dao.obtenerTodos()) {
			System.out.println(p);
		}

		dao.insertar(new Persona("Pedro"));

		for(var p: dao.obtenerTodos()) {
			System.out.println(p);
		}
	}
}
