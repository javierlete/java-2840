<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Formulario de producto</h1>

<form method="post">
	<jl:label-input etiqueta="Nombre del producto" id="nombre" />
	<jl:label-input etiqueta="Precio del producto" id="precio" />
	
	<button class="btn btn-primary">Guardar</button>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>