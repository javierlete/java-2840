package com.ipartek.formacion.ejemplospring.servicios;

import com.ipartek.formacion.ejemplospring.entidades.Producto;

public interface AdminService extends AnonimoService {

	Producto insertarProducto(Producto producto);

}
