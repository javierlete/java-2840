package com.ipartek.formacion.daos;

import com.ipartek.formacion.bibliotecas.Dao;
import com.ipartek.formacion.pojos.Persona;

public interface DaoPersona extends Dao<Persona> {
	default Iterable<Persona> obtenerPorNombre(String nombre) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
}
