package com.ipartek.formacion.tienda.controladores;

import java.io.IOException;

import com.ipartek.formacion.tienda.config.Configuracion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		// Convertir la información al formato necesario
		// Crear objeto basado en información individual
		// Ejecutar lógica de negocio
		var productos = Configuracion.DAO_PRODUCTO.obtenerTodos();
		
		// Preparar modelo para siguiente vista
		request.setAttribute("productos", productos);
		
		// Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/listado.jsp").forward(request,response);
	}
}
