package com.ipartek.formacion.ejemplos;

public class ForEjemplo {
	public static void main(String[] args) {
		// Comenzamos con el contador con el valor 1
		// Si el contador es menor o igual que 10 entramos en el bloque de llaves
		// Cuando termine el bloque de llaves, incrementamos el contador
		for (int contador = 1; contador <= 10; contador++) {
			System.out.println(contador);
		}

		int[] datos = new int[] { 1, 5, 3 };

		for (int i = 0; i < datos.length; i++) {
			int dato = datos[i]; //  datos[i] = 0, 1, 2
			System.out.println(dato); // dato = 1, 5, 3
		}

		for (int dato : datos) { // Por cada dato dentro del conjunto de datos
			System.out.println(dato); // muéstralo por pantalla
		}
	}
}
