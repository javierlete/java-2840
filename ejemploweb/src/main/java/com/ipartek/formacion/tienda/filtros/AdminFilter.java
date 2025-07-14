package com.ipartek.formacion.tienda.filtros;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/admin/*")
public class AdminFilter extends HttpFilter {

	private static final long serialVersionUID = 6888202794692302818L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(request.getSession().getAttribute("usuario") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		super.doFilter(request, response, chain);
	}
}
