package com.ipartek.formacion.ejemplospring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.servicios.AdminService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/listado")
	public String listado(Model modelo) {
		var productos = adminService.listadoProductos();
		
		modelo.addAttribute("productos", productos);
		
		return "admin/listado";
	}
	
	@GetMapping("/formulario")
	public String formulario(Producto producto) {
		return "admin/formulario";
	}
	
	@PostMapping("/formulario")
	public String formularioPost(@Valid Producto producto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "admin/formulario";
		}
		
		adminService.insertarProducto(producto);
		
		return "redirect:/admin/listado";
	}
}
