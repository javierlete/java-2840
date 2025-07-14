package com.ipartek.formacion.bibliotecas;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.ipartek.formacion.tienda.config.Configuracion;

public class Fabrica {
	private static final Properties props;

	static {
		try {
			props = new Properties();
			props.load(Configuracion.class.getClassLoader().getResourceAsStream("fabrica.properties"));
		} catch (IOException e) {
			throw new RuntimeException("No se ha podido cargar la configuración", e);
		}
	}

	// DaoProducto dao = Fabrica.obtener("ejemploweb.accesodatos.producto",
	// "dao.url");
	// AnonimoNegocio negocio =
	// Fabrica.obtener("ejemploweb.logicanegocio.anonimonegocio");
	public static Object obtener(String identificador, Object... argumentos) {
		try {
			String nombreObjeto = props.getProperty(identificador);

			Class<?> clase = Class.forName(nombreObjeto);

			Constructor<?> constructor;
			Object objeto = null;

			switch (argumentos.length) {
			case 0:
				constructor = clase.getConstructor();
				objeto = constructor.newInstance();
				break;
			case 1:
				constructor = clase.getConstructor(String.class);
				objeto = constructor.newInstance(props.getProperty((String) argumentos[0]));
				break;
			}

			return objeto;
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException("No se ha podido fabricar el objeto");
		}
	}
}
