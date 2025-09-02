'use strict';

let ul, iframe;

window.addEventListener('DOMContentLoaded', async () => {
	
	ul = document.querySelector('ul');
	iframe = document.querySelector('iframe');
		
	principal();
});

async function detalle(id) {
	ul.style.display = 'none';
	iframe.style.display = null;
	
	const respuesta = await fetch('/api/videos/' + id);
	const video = await respuesta.json();
	
	iframe.src = video.url;
}

async function principal() {
	iframe.style.display = 'none';
	ul.style.display = null;

	ul.innerHTML = '';
		
	const respuesta = await fetch('/api/videos');
	const videos = await respuesta.json();

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