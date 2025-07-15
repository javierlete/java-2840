<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>


<table>
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${carrito}" var="p">
			<tr>
				<td>${p.nombre}</td>
				<td><fmt:formatNumber type="currency" value="${p.precio}"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
