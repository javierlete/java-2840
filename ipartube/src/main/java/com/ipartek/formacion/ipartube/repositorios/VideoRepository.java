package com.ipartek.formacion.ipartube.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipartek.formacion.ipartube.entidades.Video;

public interface VideoRepository extends CrudRepository<Video, Long>, PagingAndSortingRepository<Video, Long> {
	@Query("from Video v left join fetch v.usuario")
	Iterable<Video> buscarVideosCompacto();
	
	@Query("from Video v left join fetch v.usuario")
	Page<Video> buscarVideosPaginadosCompacto(Pageable pagina);
	
	Iterable<Video> findByTituloContains(String tituloParcial);
}
