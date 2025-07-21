package com.ipartek.formacion.ejemplobibliotecas.accesodatos;

import java.util.function.Function;

import com.ipartek.formacion.bibliotecas.DaoException;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DaoUsuarioJpa implements DaoUsuario {
	private static final EntityManagerFactory EMF = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.ejemplobibliotecas.entidades");

	@Override
	public Iterable<Usuario> obtenerTodos() {
		return ejecutarJpa(em -> em.createQuery("from Usuario", Usuario.class).getResultList());
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		return ejecutarJpa(em -> em.find(Usuario.class, id));
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		return ejecutarJpa(em -> {
			em.persist(usuario);
			return usuario;
		});
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		return ejecutarJpa(em -> {
			em.merge(usuario);
			return usuario;
		});
	}

	@Override
	public void borrar(Long id) {
		ejecutarJpa(em -> {
			em.remove(em.find(Usuario.class, id));
			return null;
		});
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return ejecutarJpa(em -> em.createQuery("from Usuario u where u.email = ?1", Usuario.class).setParameter(1, email).getSingleResultOrNull());
	}

	private <T> T ejecutarJpa(Function<EntityManager, T> funcion) {
		try (EntityManager em = EMF.createEntityManager()) {
			EntityTransaction t = em.getTransaction();

			t.begin();

			T objeto = funcion.apply(em);

			t.commit();

			em.close();

			return objeto;
		} catch (Exception e) {
			throw new DaoException("Ha habido un error en la operación", e);
		}
	}

}
