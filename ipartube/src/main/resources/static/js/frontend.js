'use strict';

let ul, iframe;
let primera, anterior, siguiente, ultima;
let numero, tamanoPagina, paginas, registros;

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

	principal();
});

async function detalle(id) {
	ul.style.display = 'none';
	iframe.style.display = null;

	const respuesta = await fetch('/api/videos/' + id);
	const video = await respuesta.json();

	iframe.src = video.url;
}

async function principal(pagina = 0, tamano = 2, ordenacion = 'ASC') {
	iframe.style.display = 'none';
	ul.style.display = null;

	ul.innerHTML = '';

	const respuesta = await fetch(`/api/videos/paginados?tamano=${tamano}&pagina=${pagina}&ordenacion=${ordenacion}`); // '/api/videos');
	const contexto = await respuesta.json();

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

		principal(contexto.totalPages - 1, tamano, ordenacion);
	};

	primera.style.display = contexto.first ? 'none' : null;
	anterior.style.display = pagina == 0 ? 'none' : null;
	siguiente.style.display = pagina == contexto.totalPages - 1 ? 'none' : null;
	ultima.style.display = contexto.last ? 'none' : null;

	numero.innerText = contexto.number;
	tamanoPagina.innerText = contexto.size;
	paginas.innerText = contexto.totalPages;
	registros.innerText = contexto.totalElements;

	const videos = contexto.content;

	videos.forEach(video => {
		const li = document.createElement('li');

		li.innerHTML = `
			<li>
				<a href="javascript:detalle(${video.id})">${video.titulo}</a>
			</li>
		`;

		ul.appendChild(li);
	});
}