<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="jl" %>
<%@ attribute name="producto" type="com.ipartek.formacion.ejemplobibliotecas.entidades.Producto" %>
<div class="col">
	<fmt:formatNumber type='currency' value='${producto.precio}' var="precio" />

	<jl:tarjeta imagen="https://picsum.photos/400/300?id=${producto.id}"
		titulo="${producto.nombre}" descripcion="" pie="${precio}"
		enlace="fc/detalle?id=${producto.id}" textoEnlace="Ver detalle" />
</div>
