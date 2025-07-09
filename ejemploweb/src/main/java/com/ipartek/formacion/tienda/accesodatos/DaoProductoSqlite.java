package com.ipartek.formacion.tienda.accesodatos;

import com.ipartek.formacion.bibliotecas.DaoJdbc;
import com.ipartek.formacion.tienda.mocks.TiendaMock;
import com.ipartek.formacion.tienda.modelos.Producto;

public class DaoProductoSqlite extends DaoJdbc<Producto> implements DaoProducto {

	public DaoProductoSqlite(String url) {
		super(url);
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		return TiendaMock.PRODUCTOS.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return TiendaMock.PRODUCTOS.get(id);
	}
	
	
}
