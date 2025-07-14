package com.ipartek.formacion.tienda.config;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.tienda.accesodatos.DaoProducto;
import com.ipartek.formacion.tienda.logicanegocio.AnonimoNegocio;

public class Configuracion {
	public static final DaoProducto DAO_PRODUCTO = (DaoProducto) Fabrica.obtener("ejemploweb.accesodatos.producto", "ejemploweb.accesodatos.url");
	public static final AnonimoNegocio ANONIMO_NEGOCIO = (AnonimoNegocio) Fabrica.obtener("ejemploweb.logicanegocio.anonimonegocio");
}
