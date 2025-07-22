package com.ipartek.formacion.ejemplobibliotecas.controladores;

import java.util.Map;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.bibliotecas.web.Controlador;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AnonimoNegocio;

public class IndexControlador implements Controlador {
	private static final AnonimoNegocio NEGOCIO = (AnonimoNegocio) Fabrica.obtener("negocio.anonimo");

	@Override
	public String ejecutar(String metodo, Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida) {
		var productos = NEGOCIO.listadoProductos();

		mapaSalida.put("productos", productos);

		return "/index";
	}

}
