package com.ipartek.formacion.programas;

import static com.ipartek.formacion.bibliotecas.Consola.leerInteger;
import static com.ipartek.formacion.bibliotecas.Consola.leerLocalDate;
import static com.ipartek.formacion.bibliotecas.Consola.leerString;

import com.ipartek.formacion.daos.DaoPersona;
import com.ipartek.formacion.daos.DaoPersonaSqlite;
import com.ipartek.formacion.daos.DaoRol;
import com.ipartek.formacion.daos.DaoRolSqlite;
import com.ipartek.formacion.pojos.Persona;

public class MantenimientoPersonasConsola {
	private static final String URL_SQLITE = "jdbc:sqlite:bdd/tienda.db";

	private static final DaoPersona DAO = new DaoPersonaSqlite(URL_SQLITE);
	private static final DaoRol DAO_ROL = new DaoRolSqlite(URL_SQLITE);

	private static final boolean CON_ID = true;
	private static final boolean SIN_ID = false;

	public static void main(String[] args) {

		int opcion;

		do {
			menu();
			opcion = leerInteger("Dime una opción");
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

				6. Listado roles
				7. Obtener rol por id

				0. Salir
				""");
	}

	private static void procesar(int opcion) {
		switch (opcion) {
		case 1 -> listado();
		case 2 -> buscar();
		case 3 -> anyadir();
		case 4 -> modificar();
		case 5 -> borrar();
		case 6 -> listadoRoles();
		case 7 -> buscarRol();
		case 0 -> System.out.println("Gracias por usar esta aplicación");
		default -> System.out.println("Opción incorrecta");
		}
	}

	private static void listado() {
		for (var persona : DAO.obtenerTodos()) {
			mostrarFilaPersona(persona);
		}
	}

	private static void buscar() {
		var id = leerInteger("Dime el id a buscar");

		var persona = DAO.obtenerPorId((long) id);

		mostrarFichaPersona(persona);
	}

	private static void anyadir() {
		var persona = pedirDatosPersona(SIN_ID);

		DAO.insertar(persona);
	}

	private static void modificar() {
		var persona = pedirDatosPersona();

		DAO.modificar(persona);
	}

	private static void borrar() {
		var id = leerInteger("Dime el id a borrar");

		DAO.borrar((long) id);
	}

	private static void listadoRoles() {
		for (var rol : DAO_ROL.obtenerTodos()) {
			System.out.println(rol);
		}
	}

	private static void buscarRol() {
		var id = leerInteger("Dime el id del rol");

		var rol = DAO_ROL.obtenerPorId((long) id);
		
		System.out.println(rol);
	}

	private static void mostrarFilaPersona(Persona persona) {
		System.out.println(persona);
	}

	private static void mostrarFichaPersona(Persona persona) {
		System.out.println(persona);
	}

	private static Persona pedirDatosPersona() {
		return pedirDatosPersona(CON_ID);
	}

	private static Persona pedirDatosPersona(boolean conId) {
		do {
			try {
				Long id = null;

				if (conId) {
					id = (long) leerInteger("Id");
				}

				var nombre = leerString("Nombre");
				var fechaNacimiento = leerLocalDate("Fecha de nacimiento");

				var persona = new Persona(id, nombre, fechaNacimiento);

				return persona;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (true);
	}
}
