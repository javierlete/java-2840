package com.ipartek.formacion.ejemplobibliotecas.accesodatos;

import java.util.List;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DaoProductoJpa implements DaoProducto {
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("com.ipartek.formacion.ejemplobibliotecas.entidades");
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		EntityManager em = EMF.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		
		List<Producto> productos = em.createQuery("from Producto", Producto.class).getResultList();
		
		t.commit();
		
		em.close();
		
		return productos;
	}

	@Override
	public Producto obtenerPorId(Long id) {
		EntityManager em = EMF.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		
		Producto producto = em.find(Producto.class, id);
		
		t.commit();
		
		em.close();
		
		return producto;
	}

	@Override
	public Producto insertar(Producto producto) {
		EntityManager em = EMF.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		
		em.persist(producto);
		
		t.commit();
		
		em.close();
		
		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		EntityManager em = EMF.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		
		em.merge(producto);
		
		t.commit();
		
		em.close();
		
		return producto;
	}

	@Override
	public void borrar(Long id) {
		EntityManager em = EMF.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		
		em.remove(em.find(Producto.class, id));
		
		t.commit();
		
		em.close();
	}

}
