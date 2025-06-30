package com.ipartek.formacion.daos;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ipartek.formacion.pojos.Persona;

public class DaoPersonaSqlite implements Dao<Persona> {

	private final String url;

	public DaoPersonaSqlite(String url) {
		this.url = url;
	}

	@Override
	public Iterable<Persona> obtenerTodos() {
		return ejecutarConsultaSql("SELECT * FROM personas");
	}

	@Override
	public Persona obtenerPorId(Long id) {
		var personas = ejecutarConsultaSql("SELECT * FROM personas WHERE id=?", id);

		if (personas.iterator().hasNext()) {
			return personas.iterator().next();
		} else {
			return null;
		}
	}

	@Override
	public void insertar(Persona persona) {
		ejecutarConsultaSql("INSERT INTO personas (nombre, fecha_nacimiento) VALUES (?,?)", persona.getNombre(),
				persona.getFechaNacimiento() == null ? null : persona.getFechaNacimiento().toString());
	}

	@Override
	public void modificar(Persona persona) {
		ejecutarConsultaSql("UPDATE personas SET nombre=?, fecha_nacimiento=? WHERE id=?", persona.getNombre(),
				persona.getFechaNacimiento() == null ? null : persona.getFechaNacimiento().toString(), persona.getId());
	}

	@Override
	public void borrar(Long id) {
		ejecutarConsultaSql("DELETE FROM personas WHERE id=?", id);
	}

	private Iterable<Persona> ejecutarConsultaSql(String sql, Object... parametros) {
		try (var con = DriverManager.getConnection(url); var pst = con.prepareStatement(sql);) {

			int posicion = 1;

			for (var parametro : parametros) {
				pst.setObject(posicion, parametro);
				posicion++;
			}

			if (sql.contains("SELECT")) {
				var rs = pst.executeQuery();
				var personas = new ArrayList<Persona>();

				while (rs.next()) {
					var id = rs.getLong("id");
					var nombre = rs.getString("nombre");

					var fechaNacimientoOriginal = rs.getString("fecha_nacimiento");
					var fechaNacimiento = fechaNacimientoOriginal == null ? null
							: LocalDate.parse(fechaNacimientoOriginal);

					var persona = new Persona(id, nombre, fechaNacimiento);

					personas.add(persona);
				}

				return personas;
			} else {
				pst.executeUpdate();
				return null;
			}
		} catch (SQLException e) {
			throw new DaoException("No se ha podido hacer la operación con la base de datos", e);
		}
	}

}
