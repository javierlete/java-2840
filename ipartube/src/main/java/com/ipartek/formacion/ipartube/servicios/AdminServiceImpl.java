package com.ipartek.formacion.ipartube.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.repositorios.VideoRepository;

@Service
public class AdminServiceImpl extends AnonimoServiceImpl implements AdminService {

	@Autowired
	public VideoRepository videoRepository;
	
	@Override
	public Video crearVideo(Video video) {
		return videoRepository.save(video);
	}

	@Override
	public Video modificarVideo(Video video) {
		return videoRepository.save(video);
	}

	@Override
	public void borrarVideo(Long id) {
		videoRepository.deleteById(id);
	}

}
