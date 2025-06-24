package com.ipartek.formacion.daos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.SortedMap;

import com.ipartek.formacion.pojos.Persona;

public class DaoPersonaFichero extends DaoPersonaTreeMap implements Dao<Persona> {
	private String fichero;

	public DaoPersonaFichero(String fichero) {
		this.fichero = fichero;

		if (Files.exists(Path.of(fichero))) {
			leer();
		} else {
			guardar();
		}
	}

	@Override
	public Iterable<Persona> obtenerTodos() {
		leer();
		return super.obtenerTodos();
	}

	@Override
	public Persona obtenerPorId(Long id) {
		leer();
		return super.obtenerPorId(id);
	}

	@Override
	public void insertar(Persona persona) {
		super.insertar(persona);
		guardar();
	}

	@Override
	public void modificar(Persona persona) {
		super.modificar(persona);
		guardar();
	}

	@Override
	public void borrar(Long id) {
		super.borrar(id);
		guardar();
	}

	private void guardar() {
		try (FileOutputStream fos = new FileOutputStream(fichero);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(personas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void leer() {
		try (FileInputStream fis = new FileInputStream(fichero); ObjectInputStream ois = new ObjectInputStream(fis)) {
			personas = (SortedMap<Long, Persona>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
