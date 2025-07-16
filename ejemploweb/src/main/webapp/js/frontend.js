'use strict';

const URL = 'http://localhost:8080/ejemploweb/api/productos/';
let ul;

addEventListener('DOMContentLoaded', async () => {
	ul = document.querySelector('ul');
	
	await refrescarListado(ul);
	
	document.forms[0].addEventListener('submit', async e => {
		e.preventDefault();
		
		const form = document.forms[0];

		const boton = form.querySelector('button');
		
		boton.disabled = true;
		boton.innerHTML = 'CARGANDO';
		
		var producto = { nombre: form.nombre.value, precio: +form.precio.value };
		
		await fetch(URL, {
			method: 'POST',
			body: JSON.stringify(producto),
			headers: {
				'Content-Type': 'application/json'
			},
		});
		
		boton.disabled = false;
		boton.innerHTML = 'GUARDAR';
		
		refrescarListado();
	});
});

async function refrescarListado() {
    const respuesta = await fetch(URL);
    const productos = await respuesta.json();

	ul.innerHTML = '';
	
    productos.forEach(p => {
        const li = document.createElement('li');

        li.innerHTML = `Nombre: ${p.nombre}, Precio: ${p.precio}`;

        ul.appendChild(li);
    });
}
