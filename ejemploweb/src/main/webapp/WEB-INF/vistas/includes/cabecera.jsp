<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<fmt:setLocale value="es-ES" />
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Tienda</title>
<base href="${pageContext.request.contextPath}/">
<link rel="icon" href="../imgs/cart3.svg">
</head>
<body>
	<h1>Tienda</h1>

	<nav>
		<ul>
			<li><a href="">Listado</a></li>
			<li><a href="carrito">Carrito</a></li>
			<c:if test="${usuario == null}">
				<li><a href="login">Iniciar sesión</a></li>
			</c:if>

			<c:if test="${usuario != null}">
				<li><a href="admin/listado">Admin Listado</a></li>
				<li><a href="admin/formulario">Admin Formulario</a></li>
				<li>${usuario.nombre}</li>
				<li><a href="logout">Cerrar sesión</a></li>
			</c:if>
		</ul>
	</nav>