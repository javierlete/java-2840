package com.ipartek.formacion.bibliotecas.web;

import java.util.Map;

public interface Controlador {
	String ejecutar(String metodo, Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida);
}
