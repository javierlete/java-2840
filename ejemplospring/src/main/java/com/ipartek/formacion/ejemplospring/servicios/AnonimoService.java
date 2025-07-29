package com.ipartek.formacion.ejemplospring.servicios;

import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.entidades.Usuario;

public interface AnonimoService {
	Iterable<Producto> listadoProductos();

	Producto detalleProducto(Long id);

	Usuario autenticar(Usuario usuario);
}
