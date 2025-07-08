<%@page import="com.ipartek.formacion.pojos.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
Iterable<Persona> personas = (Iterable<Persona>) request.getAttribute("personas");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado</title>
</head>
<body>

	<ul>
		<%
		for (var persona : personas) {
		%>
		<li><%=persona%></li>
		<%
		}
		%>
	</ul>

</body>
</html>