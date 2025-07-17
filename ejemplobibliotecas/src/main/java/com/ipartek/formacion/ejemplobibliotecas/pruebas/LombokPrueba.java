package com.ipartek.formacion.ejemplobibliotecas.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

public class LombokPrueba {

	public static void main(String[] args) {
		var producto1 = new Producto();
		var producto2 = new Producto(1L, "Javier", new BigDecimal("1234"));
		var producto3 = new Producto(1L, "Javier", new BigDecimal("1234"));
		
		System.out.println(producto1);
		
		System.out.println(producto2);
		
		System.out.println(producto2.getNombre());

		System.out.println(producto2.equals(producto3));
		
		producto2.setNombre("Pepe");
		
		System.out.println(producto2.equals(producto3));
		
		System.out.println(producto2.hashCode());
		System.out.println(producto3.hashCode());
		
		Producto producto4 = Producto.builder().precio(new BigDecimal("4321")).nombre("Uno").build();
		
		System.out.println(producto4);
		
		var productoVacio = Producto.builder().build();
		
		System.out.println(productoVacio);
		
		Usuario usuario = Usuario.builder().email("email").password("password").build();
		
		System.out.println(usuario);
	}
}
