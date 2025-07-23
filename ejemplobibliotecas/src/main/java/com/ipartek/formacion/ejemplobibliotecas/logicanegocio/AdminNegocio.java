package com.ipartek.formacion.ejemplobibliotecas.logicanegocio;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

public interface AdminNegocio extends AnonimoNegocio {

	Producto insertarProducto(Producto producto);

}
