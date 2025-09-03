package com.ipartek.formacion.ipartube.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ipartek.formacion.ipartube.entidades.Video;

public interface AnonimoService {
	Iterable<Video> verListadoVideos();
	Page<Video> verListadoVideos(Pageable pagina);
	Video verDetalleVideo(Long id);
	Video nuevoVideo(Video video);
}
