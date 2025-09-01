package com.ipartek.formacion.ipartube.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.ipartube.entidades.Video;

public interface VideoRepository extends CrudRepository<Video, Long> {
	Iterable<Video> findByTituloContains(String tituloParcial);
}
