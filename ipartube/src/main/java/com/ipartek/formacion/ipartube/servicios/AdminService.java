package com.ipartek.formacion.ipartube.servicios;

import com.ipartek.formacion.ipartube.entidades.Video;

public interface AdminService extends AnonimoService {
	Video crearVideo(Video video);
	Video modificarVideo(Video video);
	void borrarVideo(Long id);
}
