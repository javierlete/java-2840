package com.ipartek.formacion.ipartex.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ipartex.entidades.Usuario;
import com.ipartek.formacion.ipartex.servicios.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("buscar-por-email")
	public Usuario buscarPorEmail(String email) {
		return usuarioService.buscarUsuarioPorEmail(email);
	}
}
