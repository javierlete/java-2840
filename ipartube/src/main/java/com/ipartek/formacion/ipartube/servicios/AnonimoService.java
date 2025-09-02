package com.ipartek.formacion.ipartube.servicios;

import com.ipartek.formacion.ipartube.entidades.Video;

public interface AnonimoService {
	Iterable<Video> verListadoVideos();
	Video verDetalleVideo(Long id);
	Video nuevoVideo(Video video);
}
