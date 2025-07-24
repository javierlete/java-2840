<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="jl" %>
<%@ attribute name="productos" type="java.lang.Iterable<com.ipartek.formacion.ejemplobibliotecas.entidades.Producto>" %>
<%@ attribute name="clases" %>
<div class="row row-cols-1 row-cols-md-3 g-4 ${clases}">
	<c:forEach items="${productos}" var="p">
		<jl:tarjeta-producto producto="${p}" />
	</c:forEach>
</div>
