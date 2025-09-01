package com.ipartek.formacion.ipartube.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.repositorios.VideoRepository;

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
	
}
