package com.ipartek.formacion.ejemplobibliotecas.controladores;

import java.util.Map;

import com.ipartek.formacion.bibliotecas.web.Controlador;

public class EjemploControlador implements Controlador {

	@Override
	public String ejecutar(String metodo, Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida) {
		mapaSalida.put("metodo", metodo);
		mapaSalida.put("dato", mapaEntrada.get("dato")[0]);
		
		return "/ejemplo";
	}

}
