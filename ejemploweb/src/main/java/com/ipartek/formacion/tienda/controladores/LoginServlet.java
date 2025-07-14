package com.ipartek.formacion.tienda.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		// Convertir la información al formato necesario
		// Crear objeto basado en información individual
		// Ejecutar lógica de negocio
		// Preparar modelo para siguiente vista
		// Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Convertir la información al formato necesario
		// Crear objeto basado en información individual
		// Ejecutar lógica de negocio
		if("javier@email.net".equals(email) && "javier".equals(password)) {
			// Preparar modelo para siguiente vista
			// Saltar a la siguiente vista
			session.setAttribute("email", email);
			response.sendRedirect("admin/listado");
		} else {
			// Preparar modelo para siguiente vista
			// Saltar a la siguiente vista
			response.sendRedirect("login");
		}
		
	}
}
