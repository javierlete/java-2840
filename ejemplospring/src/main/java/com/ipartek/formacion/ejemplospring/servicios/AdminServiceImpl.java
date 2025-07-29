package com.ipartek.formacion.ejemplospring.servicios;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.ejemplospring.entidades.Producto;

@Service
public class AdminServiceImpl extends AnonimoServiceImpl implements AdminService {

	@Override
	public Producto insertarProducto(Producto producto) {
		return productoRepository.save(producto);
	}

}
