package com.ipartek.formacion.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ipartek.formacion.bibliotecas.DaoException;
import com.ipartek.formacion.bibliotecas.DaoJdbc;
import com.ipartek.formacion.pojos.Persona;

public class DaoPersonaSqlite extends DaoJdbc<Persona> implements DaoPersona {

	public DaoPersonaSqlite(String url) {
		super(url);
	}

	@Override
	public Iterable<Persona> obtenerTodos() {
		return ejecutarConsultaSql("SELECT * FROM personas", rs -> filaAObjeto(rs));
	}

	@Override
	public Persona obtenerPorId(Long id) {
		return ejecutarConsultaSqlUno("SELECT * FROM personas WHERE id=?", rs -> filaAObjeto(rs), id);
	}

	@Override
	public void insertar(Persona persona) {
		ejecutarConsultaSql("INSERT INTO personas (nombre, fecha_nacimiento) VALUES (?,?)", objetoAFila(persona));
	}

	@Override
	public void modificar(Persona persona) {
		ejecutarConsultaSql("UPDATE personas SET nombre=?, fecha_nacimiento=? WHERE id=?", objetoAFila(persona));
	}

	@Override
	public void borrar(Long id) {
		ejecutarConsultaSql("DELETE FROM personas WHERE id=?", id);
	}

	private static Persona filaAObjeto(ResultSet rs) {
		try {
			var id = rs.getLong("id");
			var nombre = rs.getString("nombre");

			var fechaNacimientoOriginal = rs.getString("fecha_nacimiento");
			var fechaNacimiento = fechaNacimientoOriginal == null ? null : LocalDate.parse(fechaNacimientoOriginal);

			return new Persona(id, nombre, fechaNacimiento);
		} catch (SQLException e) {
			throw new DaoException("No se ha podido hacer la operación con la base de datos", e);
		}
	}

	private static Object[] objetoAFila(Persona persona) {
		return new Object[] { persona.getNombre(),
				persona.getFechaNacimiento() == null ? null : persona.getFechaNacimiento().toString(),
				persona.getId() };
	}
}
