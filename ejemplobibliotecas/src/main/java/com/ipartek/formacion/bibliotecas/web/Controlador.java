package com.ipartek.formacion.bibliotecas.web;

import java.util.Map;

public interface Controlador {
	default String ejecutar() {
		return "/index";
	}

	default String ejecutar(Map<String, Object> mapaSalida) {
		return ejecutar();
	}

	default String ejecutar(Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida) {
		return ejecutar(mapaSalida);
	}

	default String ejecutar(String metodo, Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida) {
		return ejecutar(mapaEntrada, mapaSalida);
	}
}
