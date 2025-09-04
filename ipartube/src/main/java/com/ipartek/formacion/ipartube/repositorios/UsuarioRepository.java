package com.ipartek.formacion.ipartube.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipartek.formacion.ipartube.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>, PagingAndSortingRepository<Usuario, Long> {
	Usuario findByEmail(String email);
}
