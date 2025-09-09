package com.ipartek.formacion.ipartex.servicios;

import com.ipartek.formacion.ipartex.entidades.Mensaje;
import com.ipartek.formacion.ipartex.entidades.Usuario;

public interface UsuarioService {
	Mensaje crearMensaje(Mensaje mensaje);
	Usuario buscarUsuarioPorEmail(String email);
}
