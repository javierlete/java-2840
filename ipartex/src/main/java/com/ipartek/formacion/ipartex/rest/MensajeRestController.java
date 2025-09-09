package com.ipartek.formacion.ipartex.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ipartex.entidades.Mensaje;
import com.ipartek.formacion.ipartex.servicios.AnonimoService;
import com.ipartek.formacion.ipartex.servicios.UsuarioService;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeRestController {

	@Autowired
	private AnonimoService anonimoService;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public Iterable<Mensaje> get() {
		return anonimoService.listarMensajes();
	}
	
	@PostMapping
	public Mensaje post(@RequestBody Mensaje mensaje) {
		System.out.println(mensaje);
		return usuarioService.crearMensaje(mensaje);
	}
}
