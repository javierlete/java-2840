package com.ipartek.formacion.bibliotecas.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ipartek.formacion.bibliotecas.Fabrica;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fc/*")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
		Map<String, String[]> mapaEntrada = request.getParameterMap();
		String pathInfo = request.getPathInfo();
		String metodo = request.getMethod();

		Controlador controlador = (Controlador) Fabrica.obtener(pathInfo);

		Map<String, Object> mapaSalida = new HashMap<>();
		
		String ruta = controlador.ejecutar(metodo, mapaEntrada, mapaSalida);

		mapaSalida.put("pathInfo", pathInfo);
		
//		Preparar modelo para siguiente vista
		for(Entry<String, Object> par: mapaSalida.entrySet()) {
			request.setAttribute(par.getKey(), par.getValue());
		}
		
//		Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas" + ruta + ".jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath() + ruta);
	}
}
