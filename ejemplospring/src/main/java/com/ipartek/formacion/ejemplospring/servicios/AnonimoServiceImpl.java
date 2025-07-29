package com.ipartek.formacion.ejemplospring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.entidades.Usuario;
import com.ipartek.formacion.ejemplospring.repositorios.ProductoRepository;
import com.ipartek.formacion.ejemplospring.repositorios.UsuarioRepository;

@Service
@Primary
public class AnonimoServiceImpl implements AnonimoService {
	@Autowired
	protected ProductoRepository productoRepository;
	
	@Autowired
	protected UsuarioRepository usuarioRepository;
	
	@Override
	public Iterable<Producto> listadoProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Producto detalleProducto(Long id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario autenticar(Usuario usuario) {
		var usuarioEmail = usuarioRepository.findByEmail(usuario.getEmail());
		
		if(usuarioEmail == null) {
			return null;
		}
		
		if(!usuarioEmail.getPassword().equals(usuario.getPassword())) {
			return null;
		}
		
		return usuarioEmail;
	}

}
