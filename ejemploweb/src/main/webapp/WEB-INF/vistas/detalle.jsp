<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="card mb-3">
	<div class="row g-0">
		<div class="col-md-4">
			<img src="https://picsum.photos/400/600"
				class="img-fluid rounded-start" alt="...">
		</div>
		<div class="col-md-8">
			<div class="card-body">
				<h5 class="card-title">${producto.nombre}</h5>
				<p class="card-text">This is a wider card with supporting text
					below as a natural lead-in to additional content. This content is a
					little bit longer.</p>
				<p class="card-text">
					<small class="text-body-secondary">
						<fmt:formatNumber type="currency" value="${producto.precio}" />
					</small>
				</p>
				<div>
					<a class="btn btn-primary" href="carrito?id=${producto.id}">Añadir al carrito</a>
				</div>
			</div>
		</div>
	</div>
</div>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
