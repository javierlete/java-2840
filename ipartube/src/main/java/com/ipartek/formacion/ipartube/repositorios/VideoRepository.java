package com.ipartek.formacion.ipartube.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.formacion.ipartube.entidades.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
	Iterable<Video> findByTituloContains(String tituloParcial);
}
