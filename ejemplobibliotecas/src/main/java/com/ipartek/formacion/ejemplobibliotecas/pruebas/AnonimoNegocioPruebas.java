package com.ipartek.formacion.ejemplobibliotecas.pruebas;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AnonimoNegocio;

public class AnonimoNegocioPruebas {
	public static void main(String[] args) {
		AnonimoNegocio negocio = (AnonimoNegocio) Fabrica.obtener("negocio.anonimo");

		for (var producto : negocio.listadoProductos()) {
			System.out.println(producto);
		}

		System.out.println(negocio.detalleProducto(2L));

		Usuario usuario = Usuario.builder().email("javier@email.net").password("javier").build();
		Usuario autenticado = negocio.autenticar(usuario);
		System.out.println(autenticado);

		usuario = Usuario.builder().email("aversicuela").password("nidecoña").build();
		autenticado = negocio.autenticar(usuario);
		System.out.println(autenticado);
	}
}
