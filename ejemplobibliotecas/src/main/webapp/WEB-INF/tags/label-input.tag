<%@ attribute name="etiqueta"%>
<%@ attribute name="id"%>
<div class="row mb-2">
	<label class="col-form-label col-sm-2" for="${id}">${etiqueta}</label>
	<div class="col-sm">
		<input class="form-control" name="${id}" placeholder="${etiqueta}"
			id="${id}">
	</div>
</div>