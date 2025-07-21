package com.ipartek.formacion.bibliotecas;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Fabrica {
	private static final Properties props;

	static {
		try {
			props = new Properties();
			props.load(Fabrica.class.getClassLoader().getResourceAsStream("fabrica.properties"));
		} catch (IOException e) {
			throw new RuntimeException("No se ha podido cargar la configuración", e);
		}
	}

	public static Object obtener(String identificador) {
		try {
			String nombreObjeto = props.getProperty(identificador);

			Class<?> clase = Class.forName(nombreObjeto);

			Constructor<?> constructor;
			Object objeto = null;

			constructor = clase.getConstructor();
			objeto = constructor.newInstance();

			return objeto;
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException("No se ha podido fabricar el objeto");
		}
	}
}
