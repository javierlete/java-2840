<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<div class="offset-0 col-12 offset-sm-1 col-sm-10 offset-md-2 col-md-8 offset-lg-3 col-lg-6 offset-xl-4 col-xl-4">
		<table class="table">
			<thead>
				<tr>
					<th>Nombre</th>
					<th class="text-end">Precio</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${carrito}" var="p">
					<tr>
						<td>${p.nombre}</td>
						<td class="text-end"><fmt:formatNumber type="currency"
								value="${p.precio}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
