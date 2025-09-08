package com.ipartek.formacion.ipartube.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.servicios.AdminService;

@RestController
@RequestMapping("/api/videos")
public class VideoRestController {
	@Autowired
	private AdminService adminService;

	@GetMapping
	public Iterable<Video> get() {
		return adminService.verListadoVideos();
	}

	@GetMapping("paginados")
	public Page<Video> getPaginados(@RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "10") int tamano, @RequestParam(defaultValue = "ASC") String ordenacion) {
		return adminService
				.verListadoVideos(PageRequest.of(pagina, tamano, Sort.by(Direction.fromString(ordenacion), "titulo")));
	}

	@GetMapping("{id}")
	public Video getVideo(@PathVariable Long id) {
		return adminService.verDetalleVideo(id);
	}
	
	@PostMapping
	public Video postVideo(@RequestBody Video video) {
		return adminService.crearVideo(video);
	}

	@PutMapping("{id}")
	public Video putVideo(@PathVariable Long id, @RequestBody Video video) {
		return adminService.modificarVideo(video);
	}
	
	@DeleteMapping("{id}")
	public void deleteVideo(@PathVariable Long id) {
		adminService.borrarVideo(id);
	}
}
