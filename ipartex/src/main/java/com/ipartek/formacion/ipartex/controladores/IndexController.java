package com.ipartek.formacion.ipartex.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.ipartex.entidades.Mensaje;
import com.ipartek.formacion.ipartex.servicios.AnonimoService;
import com.ipartek.formacion.ipartex.servicios.UsuarioService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private AnonimoService anonimoService;
	
	@GetMapping
	// @ResponseBody
	public String index(Model modelo) {
		var mensajes = anonimoService.listarMensajes();
		// return mensajes.toString();
		modelo.addAttribute("mensajes", mensajes);
		return "index";
	}
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public String post(Mensaje mensaje, String email) {
		var usuario = usuarioService.buscarUsuarioPorEmail(email);
		
		mensaje.setUsuario(usuario);
		
		usuarioService.crearMensaje(mensaje);
		
		return "redirect:/";
	}
}
