package com.ipartek.formacion.ejemplospring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.ejemplospring.servicios.AnonimoService;

@Controller
public class IndexController {
	@Autowired
	private AnonimoService anonimoService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	@GetMapping("/")
	public String index(Model modelo) {
		var productos = anonimoService.listadoProductos();
		
		modelo.addAttribute("productos", productos);
		
		return "index";
	}
	
	@GetMapping("/detalle")
	public String detalle(Long id, Model modelo) {
		var producto = anonimoService.detalleProducto(id);
		
		modelo.addAttribute("producto", producto);
		
		return "detalle";
	}
}
