package com.ipartek.formacion.ipartube.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.servicios.AnonimoService;

@RestController
@RequestMapping("/api/videos")
public class VideoRestController {
	@Autowired
	private AnonimoService anonimoService;

	@GetMapping
	public Iterable<Video> get() {
		return anonimoService.verListadoVideos();
	}

	@GetMapping("paginados")
	public Page<Video> getPaginados(@RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "10") int tamano, @RequestParam(defaultValue = "ASC") String ordenacion) {
		return anonimoService
				.verListadoVideos(PageRequest.of(pagina, tamano, Sort.by(Direction.fromString(ordenacion), "titulo")));
	}

	@GetMapping("{id}")
	public Video getVideo(@PathVariable Long id) {
		return anonimoService.verDetalleVideo(id);
	}
}
