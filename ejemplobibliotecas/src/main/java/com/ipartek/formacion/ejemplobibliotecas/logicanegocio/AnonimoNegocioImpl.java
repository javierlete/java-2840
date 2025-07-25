package com.ipartek.formacion.ejemplobibliotecas.logicanegocio;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoProducto;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoUsuario;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

import lombok.extern.java.Log;

@Log
public class AnonimoNegocioImpl implements AnonimoNegocio {
	protected static final DaoProducto DAO_PRODUCTO = (DaoProducto) Fabrica.obtener("dao.producto");
	protected static final DaoUsuario DAO_USUARIO = (DaoUsuario) Fabrica.obtener("dao.usuario");

	@Override
	public Iterable<Producto> listadoProductos() {
		return DAO_PRODUCTO.obtenerTodos();
	}

	@Override
	public Producto detalleProducto(Long id) {
		return DAO_PRODUCTO.obtenerPorId(id);
	}

	@Override
	public Usuario autenticar(Usuario usuario) {
		log.info("Autenticando usuario: " + usuario);

		Usuario usuarioEmail = DAO_USUARIO.buscarPorEmail(usuario.getEmail());

		log.info("Usuario por email: " + usuarioEmail);

		if (usuarioEmail == null || !usuarioEmail.getPassword().equals(usuario.getPassword())) {
			log.warning("USUARIO INCORRECTO");
			return null;
		}

		log.info("USUARIO CORRECTO");

		return usuarioEmail;
	}

}
