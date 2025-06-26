package com.ipartek.formacion.daos;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ipartek.formacion.pojos.Persona;

public class DaoPersonaSqlite implements Dao<Persona> {

	private static final String URL = "jdbc:sqlite:bdd/tienda.db";

	@Override
	public Iterable<Persona> obtenerTodos() {
		try (var con = DriverManager.getConnection(URL);
				var pst = con.prepareStatement("SELECT * FROM personas");
				var rs = pst.executeQuery()) {
			var personas = new ArrayList<Persona>();

			while (rs.next()) {
				var id = rs.getLong("id");
				var nombre = rs.getString("nombre");

				var fechaNacimientoOriginal = rs.getString("fecha_nacimiento");
				var fechaNacimiento = fechaNacimientoOriginal == null ? null : LocalDate.parse(fechaNacimientoOriginal);

				var persona = new Persona(id, nombre, fechaNacimiento);

				personas.add(persona);
			}

			return personas;
		} catch (SQLException e) {
			throw new DaoException("No se ha podido hacer la operación con la base de datos", e);
		}
	}

	@Override
	public Persona obtenerPorId(Long id) {
		try (var con = DriverManager.getConnection(URL);
				var pst = con.prepareStatement("SELECT * FROM personas WHERE id=?");
				) {
			pst.setLong(1, id);
			
			var rs = pst.executeQuery();

			if (rs.next()) {
				var nombre = rs.getString("nombre");

				var fechaNacimientoOriginal = rs.getString("fecha_nacimiento");
				var fechaNacimiento = fechaNacimientoOriginal == null ? null : LocalDate.parse(fechaNacimientoOriginal);

				var persona = new Persona(id, nombre, fechaNacimiento);
				
				return persona;
			}

			return null;
		} catch (SQLException e) {
			throw new DaoException("No se ha podido hacer la operación con la base de datos", e);
		}
	}

	@Override
	public void insertar(Persona persona) {
		try (var con = DriverManager.getConnection(URL);
				var pst = con.prepareStatement("INSERT INTO personas (nombre, fecha_nacimiento) VALUES (?,?)");) {

			pst.setString(1, persona.getNombre());
			pst.setString(2, persona.getFechaNacimiento() == null ? null : persona.getFechaNacimiento().toString());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("No se ha podido hacer la operación con la base de datos", e);
		}
	}

	@Override
	public void modificar(Persona persona) {
		try (var con = DriverManager.getConnection(URL);
				var pst = con.prepareStatement("UPDATE personas SET nombre=?, fecha_nacimiento=? WHERE id=?");){

			pst.setString(1, persona.getNombre());
			pst.setString(2, persona.getFechaNacimiento() == null ? null : persona.getFechaNacimiento().toString());
			pst.setLong(3, persona.getId());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("No se ha podido hacer la operación con la base de datos", e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (var con = DriverManager.getConnection(URL);
				var pst = con.prepareStatement("DELETE FROM personas WHERE id=?");){

			pst.setLong(1, id);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("No se ha podido hacer la operación con la base de datos", e);
		}
	}

}
