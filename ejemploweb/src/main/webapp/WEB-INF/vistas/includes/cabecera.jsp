<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<fmt:setLocale value="es-ES" />
<!DOCTYPE html>
<html class="h-100" lang="es">
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Tienda</title>
<base href="${pageContext.request.contextPath}/">
<link rel="icon" href="imgs/cart3.svg">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
	crossorigin="anonymous"></script>

</head>
<body class="h-100 d-flex flex-column">
	<nav class="navbar navbar-expand-sm bg-dark" data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Tienda</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-sm-0">
					<li class="nav-item"><a class="nav-link" href="">Listado</a></li>
					<li class="nav-item"><a class="nav-link" href="carrito">Carrito</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-sm-0">
					<c:if test="${usuario == null}">
						<li class="nav-item"><a class="nav-link" href="login">Iniciar
								sesión</a></li>
					</c:if>
					<c:if test="${usuario != null}">
						<li class="nav-item"><a class="nav-link" href="admin/listado">Admin
								Listado</a></li>
						<li class="nav-item"><a class="nav-link"
							href="admin/formulario">Admin Formulario</a></li>
						<li class="navbar-text">${usuario.nombre}</li>
						<li class="nav-item"><a class="nav-link" href="logout">Cerrar
								sesión</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>

	<main class="container my-3 flex-grow-1">