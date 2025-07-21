package com.ipartek.formacion.ejemplobibliotecas.accesodatos;

import com.ipartek.formacion.bibliotecas.DaoJpa;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

public class DaoUsuarioJpa extends DaoJpa<Usuario> implements DaoUsuario {
	public DaoUsuarioJpa() {
		super(Usuario.class);
	}
	
	@Override
	public Usuario buscarPorEmail(String email) {
		return ejecutarJpa(em -> em.createQuery("from Usuario u where u.email = ?1", Usuario.class).setParameter(1, email).getSingleResultOrNull());
	}
}
