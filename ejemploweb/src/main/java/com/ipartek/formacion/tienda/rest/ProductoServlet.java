package com.ipartek.formacion.tienda.rest;

import static com.ipartek.formacion.tienda.config.Configuracion.DAO_PRODUCTO;

import java.io.IOException;

import com.google.gson.Gson;
import com.ipartek.formacion.tienda.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/productos/*")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Gson GSON = new Gson();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");

		Long id = obtenerId(request);

		String json;

		if (id == null) {
			var productos = DAO_PRODUCTO.obtenerTodos();
			json = GSON.toJson(productos);
		} else {
			var producto = DAO_PRODUCTO.obtenerPorId(id);
			json = GSON.toJson(producto);
		}
		response.getWriter().append(json);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		
		var jsonReader = request.getReader();
		var producto = GSON.fromJson(jsonReader, Producto.class);
		
		DAO_PRODUCTO.insertar(producto);
		
		var productoInsertado = producto;
		var json = GSON.toJson(productoInsertado);
		
		response.setStatus(HttpServletResponse.SC_CREATED);
		response.getWriter().append(json);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		
		@SuppressWarnings("unused")
		Long id = obtenerId(request);
		
		var jsonReader = request.getReader();
		var producto = GSON.fromJson(jsonReader, Producto.class);
		
		DAO_PRODUCTO.modificar(producto);
		
		var productoModificado = producto;
		var json = GSON.toJson(productoModificado);
		
		response.getWriter().append(json);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = obtenerId(request);

		DAO_PRODUCTO.borrar(id);
		
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
	
	private Long obtenerId(HttpServletRequest request) {
		String path = request.getPathInfo();

		Long id = null;

		if (path != null && path.length() > 1) {
			String sId = path.substring(1);

			id = Long.parseLong(sId);
		}
		return id;
	}
}
