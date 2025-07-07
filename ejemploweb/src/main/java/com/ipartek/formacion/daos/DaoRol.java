package com.ipartek.formacion.daos;

import com.ipartek.formacion.bibliotecas.Dao;
import com.ipartek.formacion.pojos.Rol;

public interface DaoRol extends Dao<Rol> {
	default Rol obtenerPorNombre(String nombre) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
}
