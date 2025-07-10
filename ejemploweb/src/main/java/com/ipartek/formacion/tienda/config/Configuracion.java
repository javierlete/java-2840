package com.ipartek.formacion.tienda.config;

import com.ipartek.formacion.tienda.accesodatos.DaoProducto;
import com.ipartek.formacion.tienda.accesodatos.DaoProductoSqlite;

public class Configuracion {
	private static final String DAO_URL = "jdbc:sqlite:C:/Users/JavierLete/git/java-2840/ejemploweb/bdd/tienda.db";
	public static final DaoProducto DAO_PRODUCTO = new DaoProductoSqlite(DAO_URL);
}
