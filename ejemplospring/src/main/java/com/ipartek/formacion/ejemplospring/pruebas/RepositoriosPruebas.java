package com.ipartek.formacion.ejemplospring.pruebas;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ipartek.formacion.ejemplospring.entidades.Categoria;
import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.entidades.Usuario;
import com.ipartek.formacion.ejemplospring.repositorios.CategoriaRepository;
import com.ipartek.formacion.ejemplospring.repositorios.ProductoRepository;
import com.ipartek.formacion.ejemplospring.repositorios.UsuarioRepository;

@Component
@Order(1)
public class RepositoriosPruebas implements CommandLineRunner {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		var infor = Categoria.builder().nombre("Informática").build();
		var elec = Categoria.builder().nombre("Electrónica").build();

		categoriaRepository.save(infor);
		categoriaRepository.save(elec);

		for (int i = 1; i <= 5; i++) {
			productoRepository.save(Producto.builder().nombre("Producto " + i).precio(new BigDecimal(1000 + i))
					.categoria(i % 2 == 1 ? infor : elec).build());
		}
		
		for(var categoria: categoriaRepository.findAll()) {
			System.out.println(categoria);
		}
		
		for(var producto: productoRepository.findAll()) {
			System.out.println(producto);
		}
		
		for(var producto: productoRepository.findByCategoriaId(1L)) {
			System.out.println(producto);
		}
		
		var javier = Usuario.builder().rol("ADMINISTRADOR").nombre("Javier").email("javier@email.net").password(passwordEncoder.encode("javier")).build();
		var pepe = Usuario.builder().nombre("Pepe").email("pepe@email.net").password(passwordEncoder.encode("pepe")).build();
		
		usuarioRepository.save(javier);
		usuarioRepository.save(pepe);
		
		for(var usuario: usuarioRepository.findAll()) {
			System.out.println(usuario);
		}
		
		System.out.println(usuarioRepository.findByEmail("javier@email.net"));
		System.out.println(usuarioRepository.buscarPorEmail("pepe@email.net"));
	}

}
