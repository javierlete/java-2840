package com.ipartek.formacion.tienda.logicanegocio;

import com.ipartek.formacion.tienda.modelos.Usuario;

public class AnonimoNegocioHardCodeado implements AnonimoNegocio {

	@Override
	public Usuario autenticar(Usuario usuario) {
		if ("javier@email.net".equals(usuario.getEmail()) && "javier".equals(usuario.getPassword())) {
			return new Usuario(1L, "Javier", usuario.getEmail(), usuario.getPassword());
		}

		return null;
	}

}
