package com.ipartek.formacion.ipartube.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.repositorios.VideoRepository;

@Primary
@Service
public class AnonimoServiceImpl implements AnonimoService {

	@Autowired
	private VideoRepository videoRepository;

	@Override
	public Iterable<Video> verListadoVideos() {
		return videoRepository.findAll();
	}

	@Override
	public Video verDetalleVideo(Long id) {
		return videoRepository.findById(id).orElse(null);
	}

	@Override
	public Video nuevoVideo(Video video) {
		return videoRepository.save(video);
	}

	@Override
	public Page<Video> verListadoVideos(Pageable pagina) {
		return videoRepository.findAll(pagina);
	}
	
}
