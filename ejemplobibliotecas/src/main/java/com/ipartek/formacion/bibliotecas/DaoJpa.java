package com.ipartek.formacion.bibliotecas;

import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DaoJpa<T> implements Dao<T> {
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("daojpa");

	private Class<T> tipo;

	public DaoJpa(Class<T> tipo) {
		this.tipo = tipo;
	}

	@Override
	public Iterable<T> obtenerTodos() {
		return ejecutarJpa(em -> em.createQuery("from " + tipo.getSimpleName(), tipo).getResultList());
	}

	@Override
	public T obtenerPorId(Long id) {
		return ejecutarJpa(em -> em.find(tipo, id));
	}

	@Override
	public T insertar(T objeto) {
		return ejecutarJpa(em -> {
			em.persist(objeto);
			return objeto;
		});
	}

	@Override
	public T modificar(T objeto) {
		return ejecutarJpa(em -> {
			em.merge(objeto);
			return objeto;
		});
	}

	@Override
	public void borrar(Long id) {
		ejecutarJpa(em -> {
			em.remove(em.find(tipo, id));
			return null;
		});
	}

	protected <R> R ejecutarJpa(Function<EntityManager, R> funcion) {
		try (EntityManager em = EMF.createEntityManager()) {
			EntityTransaction t = em.getTransaction();

			t.begin();

			R objeto = funcion.apply(em);

			t.commit();

			em.close();

			return objeto;
		} catch (Exception e) {
			throw new DaoException("Ha habido un error en la operación", e);
		}
	}

}
