package com.ipartek.formacion.bibliotecas;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new DaoException("NO IMPLEMENTADO");
	}

	default T obtenerPorId(Long id) {
		throw new DaoException("NO IMPLEMENTADO");
	}

	default T insertar(T objeto) {
		throw new DaoException("NO IMPLEMENTADO");
	}

	default T modificar(T objeto) {
		throw new DaoException("NO IMPLEMENTADO");
	}

	default void borrar(Long id) {
		throw new DaoException("NO IMPLEMENTADO");
	}
}
