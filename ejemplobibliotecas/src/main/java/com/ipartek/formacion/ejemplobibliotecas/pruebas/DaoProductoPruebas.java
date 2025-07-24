package com.ipartek.formacion.ejemplobibliotecas.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoCategoria;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoProducto;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Categoria;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

public class DaoProductoPruebas {
	public static void main(String[] args) {
		DaoProducto dao = (DaoProducto) Fabrica.obtener("dao.producto");
		DaoCategoria daoCategoria = (DaoCategoria) Fabrica.obtener("dao.categoria");

		Categoria infor = Categoria.builder().nombre("Informática").build();
		Categoria elec = Categoria.builder().nombre("Electrónica").build();
		
		daoCategoria.insertar(infor);
		daoCategoria.insertar(elec);
		
		dao.insertar(Producto.builder().nombre("Portátil").precio(new BigDecimal("1234")).categoria(infor).build());
		dao.insertar(Producto.builder().nombre("MANIJA").precio(new BigDecimal("234")).categoria(elec).build());
		dao.insertar(Producto.builder().nombre("Ratón").precio(new BigDecimal("34")).categoria(Categoria.builder().id(1L).build()).build());
		dao.insertar(Producto.builder().nombre("Patatas").precio(new BigDecimal("4")).categoria(elec).build());
		dao.insertar(Producto.builder().nombre("Nevera").precio(new BigDecimal("543")).categoria(elec).build());

		dao.modificar(Producto.builder().id(2L).nombre("Monitor").precio(new BigDecimal("234")).categoria(infor).build());

		dao.borrar(4L);

		for (var producto : dao.obtenerTodos()) {
			System.out.println(producto);
		}

		Producto producto = dao.obtenerPorId(3L);
		System.out.println(producto);
		
		Categoria categoria = daoCategoria.obtenerPorId(producto.getCategoria().getId());
		
		System.out.println(categoria);
		
		for(var p: dao.buscarPorCategoria(2L)) {
			System.out.println(p);
		}
	}
}
