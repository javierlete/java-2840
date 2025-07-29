package com.ipartek.formacion.ejemplospring.pruebas;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ipartek.formacion.ejemplospring.entidades.Categoria;
import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.servicios.AdminService;
import com.ipartek.formacion.ejemplospring.servicios.AnonimoService;

@Component
@Order(2)
public class ServiciosPruebas implements CommandLineRunner {

	@Autowired
	private AnonimoService anonimoService;

	@Autowired
	private AdminService adminService;

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria = Categoria.builder().id(1L).build();
		Producto producto = Producto.builder().nombre("Prueba").precio(BigDecimal.ONE).categoria(categoria).build();
		
		adminService.insertarProducto(producto);

		anonimoService.listadoProductos().forEach(System.out::println);
	}

}
