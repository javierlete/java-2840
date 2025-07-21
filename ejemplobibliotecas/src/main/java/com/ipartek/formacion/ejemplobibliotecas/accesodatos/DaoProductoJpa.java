package com.ipartek.formacion.ejemplobibliotecas.accesodatos;

import java.util.function.Function;

import com.ipartek.formacion.bibliotecas.DaoException;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DaoProductoJpa implements DaoProducto {
	private static final EntityManagerFactory EMF = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.ejemplobibliotecas.entidades");

	@Override
	public Iterable<Producto> obtenerTodos() {
		return ejecutarJpa(em -> em.createQuery("from Producto", Producto.class).getResultList());
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return ejecutarJpa(em -> em.find(Producto.class, id));
	}

	@Override
	public Producto insertar(Producto producto) {
		return ejecutarJpa(em -> {
			em.persist(producto);
			return producto;
		});
	}

	@Override
	public Producto modificar(Producto producto) {
		return ejecutarJpa(em -> {
			em.merge(producto);
			return producto;
		});
	}

	@Override
	public void borrar(Long id) {
		ejecutarJpa(em -> {
			em.remove(em.find(Producto.class, id));
			return null;
		});
	}

	private <T> T ejecutarJpa(Function<EntityManager, T> funcion) {
		try (EntityManager em = EMF.createEntityManager()) {
			EntityTransaction t = em.getTransaction();

			t.begin();

			T objeto = funcion.apply(em);

			t.commit();

			em.close();

			return objeto;
		} catch(Exception e) {
			throw new DaoException("Ha habido un error en la operación", e);
		}
	}

}
