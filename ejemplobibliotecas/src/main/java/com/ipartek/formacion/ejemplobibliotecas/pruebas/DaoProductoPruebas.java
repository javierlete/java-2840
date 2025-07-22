package com.ipartek.formacion.ejemplobibliotecas.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoProducto;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

public class DaoProductoPruebas {
	public static void main(String[] args) {
		DaoProducto dao = (DaoProducto) Fabrica.obtener("dao.producto");

		dao.insertar(Producto.builder().nombre("Portátil").precio(new BigDecimal("1234")).build());
		dao.insertar(Producto.builder().nombre("MANIJA").precio(new BigDecimal("234")).build());
		dao.insertar(Producto.builder().nombre("Ratón").precio(new BigDecimal("34")).build());
		dao.insertar(Producto.builder().nombre("Patatas").precio(new BigDecimal("4")).build());

		dao.modificar(Producto.builder().id(2L).nombre("Monitor").precio(new BigDecimal("234")).build());

		dao.borrar(4L);

		for (var producto : dao.obtenerTodos()) {
			System.out.println(producto);
		}

		System.out.println(dao.obtenerPorId(1L));
	}
}
