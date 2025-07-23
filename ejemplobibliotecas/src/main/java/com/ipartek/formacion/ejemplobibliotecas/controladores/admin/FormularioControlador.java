package com.ipartek.formacion.ejemplobibliotecas.controladores.admin;

import java.math.BigDecimal;
import java.util.Map;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.bibliotecas.web.Controlador;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AdminNegocio;

public class FormularioControlador implements Controlador {
	private static final AdminNegocio NEGOCIO = (AdminNegocio) Fabrica.obtener("negocio.admin");
	
	@Override
	public String ejecutar(String metodo, Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida) {
		if("GET".equals(metodo)) {
			return "/admin/formulario";
		}
		
		String nombre = mapaEntrada.get("nombre")[0];
		String sPrecio = mapaEntrada.get("precio")[0];
		
		BigDecimal precio = new BigDecimal(sPrecio);
		
		Producto producto = Producto.builder().nombre(nombre).precio(precio).build();
		
		NEGOCIO.insertarProducto(producto);
		
		var productos = NEGOCIO.listadoProductos();
		
		mapaSalida.put("productos", productos);
		
		return "/index";
	}

}
