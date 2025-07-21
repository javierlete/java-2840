package com.ipartek.formacion.ejemplobibliotecas.pruebas;

import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoUsuario;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoUsuarioJpa;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

public class DaoUsuarioPruebas {
	public static void main(String[] args) {
		DaoUsuario dao = new DaoUsuarioJpa();
		
		dao.insertar(Usuario.builder().email("javier@email.net").password("javier").nombre("Javier").build());
		dao.insertar(Usuario.builder().email("pepe@email.net").password("pepirote").nombre("Pepe").build());
		dao.insertar(Usuario.builder().email("javier@email.net").password("javier").nombre("Javier").build());
		
		dao.modificar(Usuario.builder().id(2L).email("pepe@email.net").password("pepirote").nombre("Pepe").build());
		
		dao.borrar(3L);
		
		for(var usuario: dao.obtenerTodos()) {
			System.out.println(usuario);
		}
		
		System.out.println(dao.obtenerPorId(2L));
		
		System.out.println(dao.buscarPorEmail("javier@email.net"));
	}
}
