<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<div
		class="offset-0 col-12 offset-sm-1 col-sm-10 offset-md-2 col-md-8 offset-lg-3 col-lg-6">
		<form action="login" method="post">
			<div class="row mb-3">
				<label for="email" class="col-md-4 col-form-label">Correo
					electrónico</label>
				<div class="col-md">
					<input type="email" class="form-control" id="email" name="email">
				</div>
			</div>
			<div class="row mb-3">
				<label for="password" class="col-md-4 col-form-label">Contraseña</label>
				<div class="col-md">
					<input type="password" class="form-control" id="password"
						name="password">
				</div>
			</div>
			<div class="row mb-3">
				<div class="offset-md-4 col-md">
					<button type="submit" class="btn btn-primary">Iniciar
						sesión</button>
				</div>
			</div>

		</form>
	</div>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
