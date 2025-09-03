package com.ipartek.formacion.ipartube.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.servicios.AnonimoService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private AnonimoService anonimoService;

	@GetMapping
	public String index(Model modelo, @RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "10") int tamano, @RequestParam(defaultValue="ASC") String ordenacion) {
		var videos = anonimoService
				.verListadoVideos(PageRequest.of(pagina, tamano, Sort.by(Direction.fromString(ordenacion), "titulo")));
		modelo.addAttribute("videos", videos);
		return "index";
	}

	@GetMapping("video")
	public String video(Long id, Model modelo) {
		var video = anonimoService.verDetalleVideo(id);
		modelo.addAttribute("video", video);
		return "video";
	}

	@GetMapping("nuevo")
	public String nuevo() {
		return "nuevo";
	}

	@PostMapping("nuevo")
	public String nuevoPost(Video video) {
		anonimoService.nuevoVideo(video);

		return "redirect:/";
	}
}
