package com.ipartek.formacion.ejemplobibliotecas.logicanegocio;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

import lombok.extern.java.Log;

@Log
public class AdminNegocioImpl extends AnonimoNegocioImpl implements AdminNegocio {

	@Override
	public Producto insertarProducto(Producto producto) {
		log.info(producto.toString());
		return DAO_PRODUCTO.insertar(producto);
	}

}
