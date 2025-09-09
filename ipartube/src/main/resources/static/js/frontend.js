'use strict';

let ul, iframe;
let primera, anterior, siguiente, ultima;
let numero, tamanoPagina, paginas, registros;

const URL = '/api/videos';

window.addEventListener('DOMContentLoaded', async () => {
	ul = document.querySelector('ul');
	iframe = document.querySelector('iframe');

	primera = document.getElementById('primera');
	anterior = document.getElementById('anterior');
	siguiente = document.getElementById('siguiente');
	ultima = document.getElementById('ultima');

	numero = document.getElementById('numero');
	tamanoPagina = document.getElementById('tamano');
	paginas = document.getElementById('paginas');
	registros = document.getElementById('registros');

	document.forms[0].addEventListener('submit', guardar);
	
	principal();
});

async function detalle(id) {
	mostrar('detalle');

	const respuesta = await fetch(`${URL}/${id}`);
	const video = await respuesta.json();

	iframe.src = video.url;
}

async function principal(pagina = 0, tamano = 2, ordenacion = 'ASC') {
	mostrar('listado');

	ul.innerHTML = '';

	const respuesta = await fetch(`${URL}/paginados?tamano=${tamano}&pagina=${pagina}&ordenacion=${ordenacion}`); // '/api/videos');
	const contexto = await respuesta.json();
	
	const page = contexto.page;

	primera.onclick = e => {
		e.preventDefault();

		principal(0, tamano, ordenacion);
	};

	anterior.onclick = e => {
		e.preventDefault();

		principal(pagina - 1, tamano, ordenacion);
	};

	siguiente.onclick = e => {
		e.preventDefault();

		principal(pagina + 1, tamano, ordenacion);
	};

	ultima.onclick = e => {
		e.preventDefault();

		principal(page.totalPages - 1, tamano, ordenacion);
	};

	primera.style.display = pagina == 0 ? 'none' : null;
	anterior.style.display = pagina == 0 ? 'none' : null;
	siguiente.style.display = pagina == page.totalPages - 1 ? 'none' : null;
	ultima.style.display = pagina == page.totalPages - 1 ? 'none' : null;

	numero.innerText = page.number;
	tamanoPagina.innerText = page.size;
	paginas.innerText = page.totalPages;
	registros.innerText = page.totalElements;

	const videos = contexto.content;

	videos.forEach(video => {
		const li = document.createElement('li');

		li.innerHTML = `
			<li>
				<a href="javascript:detalle(${video.id})">${video.titulo}</a>
				<a href="javascript:editar(${video.id})">[Editar]</a>
				<a href="javascript:borrar(${video.id})">[Borrar]</a>
			</li>
		`;

		ul.appendChild(li);
	});
}

function nuevo() {
	mostrar('formulario');

	document.forms[0].reset();
}

async function editar(id) {
	const respuesta = await fetch(`${URL}/${id}`);
	const video = await respuesta.json();

	document.forms[0]['id'].value = video.id;
	document.forms[0].titulo.value = video.titulo;
	document.forms[0].url.value = video.url;
	document.forms[0].descripcion.value = video.descripcion;

	mostrar('formulario');
}

async function borrar(id) {
	if (!confirm('¿Estás seguro?')) {
		return;
	}

	console.log(await fetch(`${URL}/${id}`, { method: 'DELETE' }));
	
	principal();
}


function mostrar(id) {
	const sections = document.querySelectorAll('section');
	sections.forEach(section => section.style.display = 'none');

	document.getElementById(id).style.display = null;
}

async function guardar(e) {
	e.preventDefault();
	
	const video = { 
		titulo: document.forms[0].titulo.value,
		url: document.forms[0].url.value,
		descripcion: document.forms[0].descripcion.value,
	}

	console.log(video);
	
	if(document.forms[0]['id'].value) {
		video.id = +document.forms[0]['id'].value;
		
		const respuesta = await fetch(`${URL}/${video.id}`, {
			method: 'PUT',
			body: JSON.stringify(video),
			headers: {
				'Content-type': 'application/json'
			}
		});
		
		const videoResultado = await respuesta.json();
		
		console.log(videoResultado);
	} else {
		const respuesta = await fetch(URL, {
			method: 'POST',
			body: JSON.stringify(video),
			headers: {
				'Content-type': 'application/json'
			}
		});
		
		const videoResultado = await respuesta.json();
		
		console.log(videoResultado);
	}

	principal();	
}