package com.ipartek.formacion.ejemplobibliotecas.controladores;

import java.util.Map;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.bibliotecas.web.Controlador;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AnonimoNegocio;

public class DetalleControlador implements Controlador {
	private static final AnonimoNegocio NEGOCIO = (AnonimoNegocio) Fabrica.obtener("negocio.anonimo");

	@Override
	public String ejecutar(Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida) {
		String sId = mapaEntrada.get("id")[0];
		
		Long id = Long.parseLong(sId);
		
		Producto producto = NEGOCIO.detalleProducto(id);
		
		mapaSalida.put("producto", producto);
		
		return "/detalle";
	}

}
