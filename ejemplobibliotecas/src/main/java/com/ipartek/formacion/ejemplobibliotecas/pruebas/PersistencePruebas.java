package com.ipartek.formacion.ejemplobibliotecas.pruebas;

import java.math.BigDecimal;
import java.util.List;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersistencePruebas {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.ipartek.formacion.ejemplobibliotecas.entidades");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		var producto = Producto.builder().nombre("Portátil").precio(new BigDecimal("1234")).build();
		
		entityManager.persist(producto);
		
		entityManager.merge(Producto.builder().id(2L).nombre("MODIFICADO").precio(new BigDecimal("4321")).build());
		
		// entityManager.remove(entityManager.find(Producto.class, 1L));
		
		List<Producto> productos = entityManager.createQuery("from Producto", Producto.class).getResultList();
		
		for(var p: productos) {
			System.out.println(p);
		}
		
		System.out.println(entityManager.find(Producto.class, 2L));
		
		transaction.commit();
		
		entityManager.close();
	}

}
