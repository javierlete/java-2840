<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>


<c:forEach items="${productos}" var="p">
	<div>
		<a href="detalle?id=${p.id}">${p.nombre}</a>
		<fmt:formatNumber type="currency" value="${p.precio}" />
	</div>
</c:forEach>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
