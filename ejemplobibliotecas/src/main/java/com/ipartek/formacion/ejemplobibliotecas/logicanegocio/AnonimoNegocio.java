package com.ipartek.formacion.ejemplobibliotecas.logicanegocio;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

public interface AnonimoNegocio {
	Iterable<Producto> listadoProductos();
	Producto detalleProducto(Long id);
	
	Usuario autenticar(Usuario usuario);
}
