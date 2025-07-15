package com.ipartek.formacion.tienda.controladores;

import java.io.IOException;
import java.util.List;

import com.ipartek.formacion.tienda.config.Configuracion;
import com.ipartek.formacion.tienda.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		@SuppressWarnings("unchecked")
		var carrito = (List<Producto>) request.getSession().getAttribute("carrito");

		String sId = request.getParameter("id");

		if (sId != null) {
			// Convertir la información al formato necesario
			Long id = Long.parseLong(sId);

			// Crear objeto basado en información individual
			// Ejecutar lógica de negocio
			var producto = Configuracion.DAO_PRODUCTO.obtenerPorId(id);

			if (producto != null) {
				carrito.add(producto);
			}
		}
		// Preparar modelo para siguiente vista
		// Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/carrito.jsp").forward(request, response);
	}
}
