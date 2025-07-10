package com.ipartek.formacion.tienda.config;

import java.io.IOException;
import java.util.Properties;

import com.ipartek.formacion.tienda.accesodatos.DaoProducto;
import com.ipartek.formacion.tienda.accesodatos.DaoProductoSqlite;

public class Configuracion {
	public static final DaoProducto DAO_PRODUCTO;
	
	static {
		try {
			Properties props = new Properties();
			props.load(Configuracion.class.getClassLoader().getResourceAsStream("tienda.properties"));
			
			String url = props.getProperty("dao.url");
			DAO_PRODUCTO = new DaoProductoSqlite(url);
		} catch (IOException e) {
			throw new RuntimeException("No se ha podido cargar la configuración", e);
		}
	}

}
