package com.ipartek.formacion.tienda.controladores;

import java.io.IOException;

import com.ipartek.formacion.tienda.config.Configuracion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detalle")
public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		String sId = request.getParameter("id");
		
		// Convertir la información al formato necesario
		Long id = Long.parseLong(sId);
		
		// Crear objeto basado en información individual
		// Ejecutar lógica de negocio
		var producto = Configuracion.DAO_PRODUCTO.obtenerPorId(id);
		
		// Preparar modelo para siguiente vista
		request.setAttribute("producto", producto);
		
		// Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/detalle.jsp").forward(request, response);
	}
}
