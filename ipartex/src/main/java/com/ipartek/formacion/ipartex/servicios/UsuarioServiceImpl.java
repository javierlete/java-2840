package com.ipartek.formacion.ipartex.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartex.entidades.Mensaje;
import com.ipartek.formacion.ipartex.entidades.Usuario;
import com.ipartek.formacion.ipartex.repositorios.MensajeRepository;
import com.ipartek.formacion.ipartex.repositorios.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private MensajeRepository mensajeRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Mensaje crearMensaje(Mensaje mensaje) {
		return mensajeRepository.save(mensaje);
	}

	@Override
	public Usuario buscarUsuarioPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

}
