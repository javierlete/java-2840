package com.ipartek.formacion.ejemplospring.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.ejemplospring.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	Usuario findByEmail(String email);
	
	@Query("from Usuario u where u.email=:email")
	Usuario buscarPorEmail(String email);
}
