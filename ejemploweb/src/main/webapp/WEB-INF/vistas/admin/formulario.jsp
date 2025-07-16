<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<!-- ${producto} -->
<!-- ${producto.errores} -->

<%-- <p>${producto}</p> --%>

<form action="admin/formulario" method="post" class="needs-validation"
	novalidate>
	<input name="id" type="hidden" value="${producto.id}">

	<div class="row mb-3">
		<label for="nombre" class="col-md-4 col-form-label">Nombre</label>
		<div class="col-md">
			<input type="text" required class="form-control ${producto.errores.nombre != null ? 'is-invalid' : ''}" id="nombre"
				name="nombre" value="${producto.nombre}">
			<div class="invalid-feedback">El nombre es obligatorio</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="precio" class="col-md-4 col-form-label">Precio</label>
		<div class="col-md">
			<input type="number" required step=".01" min="0" class="form-control ${producto.errores.precio != null ? 'is-invalid' : ''}"
				id="precio" name="precio" value="${producto.precio}">
			<div class="invalid-feedback">El precio es obligatorio y debe ser un número positivo</div>
		</div>
	</div>
	<div class="row mb-3">
		<div class="offset-md-4 col-md">
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>
	</div>
</form>

<script>
//Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()
</script>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
