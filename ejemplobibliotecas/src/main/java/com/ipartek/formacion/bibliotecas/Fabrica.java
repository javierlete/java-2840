package com.ipartek.formacion.bibliotecas;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import lombok.extern.java.Log;

@Log
public class Fabrica {
	private static final Map<String, Object> OBJETOS = new HashMap<>();
	
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
			if(OBJETOS.containsKey(identificador)) {
				return OBJETOS.get(identificador);
			}
			
			String nombreObjeto = props.getProperty(identificador);

			log.info(identificador);
			log.info(nombreObjeto);

			if(nombreObjeto == null) {
				throw new RuntimeException("No se ha encontrado " + identificador + " en el fichero de configuración");
			}
			
			Class<?> clase = Class.forName(nombreObjeto);

			Constructor<?> constructor = clase.getConstructor();
			Object objeto = constructor.newInstance();

			OBJETOS.put(identificador, objeto);
			
			return objeto;
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException("No se ha podido fabricar el objeto");
		}
	}
}
