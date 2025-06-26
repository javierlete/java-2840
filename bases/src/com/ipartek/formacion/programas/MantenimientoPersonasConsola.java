package com.ipartek.formacion.programas;

import com.ipartek.formacion.bibliotecas.Consola;
import com.ipartek.formacion.daos.Dao;
import com.ipartek.formacion.daos.DaoPersonaSqlite;
import com.ipartek.formacion.pojos.Persona;

public class MantenimientoPersonasConsola {
	private static final Dao<Persona> DAO = new DaoPersonaSqlite();

	public static void main(String[] args) {

		int opcion;

		do {
			menu();
			opcion = Consola.leerInteger("Dime una opción");
			procesar(opcion);
		} while (opcion != 0);
	}

	private static void menu() {
		System.out.println("""
				1. Listado
				2. Buscar por id

				3. Añadir
				4. Modificar
				5. Borrar

				0. Salir
				""");
	}

	private static void procesar(int opcion) {
		switch (opcion) {
		case 1:
			listado();
			break;
		case 2:
			buscar();
			break;
		case 3:
			anyadir();
			break;
		case 4:
			modificar();
			break;
		case 5:
			borrar();
			break;
		case 0:
			System.out.println("Gracias por usar esta aplicación");
			break;
		default:
			System.out.println("Opción incorrecta");
		}
	}

	private static void listado() {
		for (var persona : DAO.obtenerTodos()) {
			System.out.println(persona);
		}
	}

	private static void buscar() {
		var id = Consola.leerInteger("Dime el id a buscar");

		var persona = DAO.obtenerPorId((long) id);

		System.out.println(persona);
	}

	private static void anyadir() {
		var nombre = Consola.leerString("Nombre");
		var fechaNacimiento = Consola.leerLocalDate("Fecha de nacimiento");

		var persona = new Persona(nombre, fechaNacimiento);

		DAO.insertar(persona);
	}

	private static void modificar() {
		var id = Consola.leerInteger("Id");
		var nombre = Consola.leerString("Nombre");
		var fechaNacimiento = Consola.leerLocalDate("Fecha de nacimiento");

		var persona = new Persona((long) id, nombre, fechaNacimiento);

		DAO.modificar(persona);
	}

	private static void borrar() {
		var id = Consola.leerInteger("Dime el id a borrar");

		DAO.borrar((long) id);
	}
}
