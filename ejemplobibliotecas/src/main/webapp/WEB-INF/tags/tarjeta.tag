<%@ attribute name="imagen" %>
<%@ attribute name="titulo" %>
<%@ attribute name="descripcion" %>
<%@ attribute name="enlace" %>
<%@ attribute name="textoEnlace" %>
<%@ attribute name="pie" %>

<div class="card h-100">
	<img src="${imagen}" class="card-img-top"
		alt="${titulo}">
	<div class="card-body">
		<h5 class="card-title">${titulo}</h5>
		<p class="card-text">${descripcion}</p>
		<p>
			<a href="detalle?id=${enlace}">${textoEnlace}</a>
		</p>
	</div>
	<div class="card-footer">
		<small class="text-body-secondary">${pie}</small>
	</div>
</div>