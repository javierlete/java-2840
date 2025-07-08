<%@ page import="com.ipartek.formacion.daos.DaoPersonaSqlite"%>
<%@ page import="com.ipartek.formacion.daos.DaoPersona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String nombre = "Teclea un id para darte el nombre";

String sId = request.getParameter("id");

if (sId != null) {
	Long id = Long.parseLong(sId);

	DaoPersona dao = new DaoPersonaSqlite("jdbc:sqlite:C:/Users/JavierLete/git/java-2840/bases/bdd/tienda.db");

	var persona = dao.obtenerPorId(id);

	nombre = persona.getNombre();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="buscarpersona.jsp" method="post">
		<input name="id">
		<button>Buscar por id</button>
	</form>

	<p><%=nombre%></p>
</body>
</html>