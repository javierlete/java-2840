<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<!-- ${producto} -->
<!-- ${producto.errores} -->

<%-- <p>${producto}</p> --%>

<form action="admin/formulario" method="post">
	<div>
		<input name="id" type="hidden" value="${producto.id}"> <span></span>
	</div>
	<div>
		<input name="nombre" type="text" required placeholder="Nombre"
			value="${producto.nombre}"> <span>${producto.errores.nombre}</span>
	</div>
	<div>
		<input name="precio" type="number" required step=".01" min="0" placeholder="Precio"
			value="${producto.precio}"> <span>${producto.errores.precio}</span>
	</div>

		<button>Guardar</button>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
