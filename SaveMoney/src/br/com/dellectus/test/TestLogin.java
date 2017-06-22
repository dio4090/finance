package br.com.dellectus.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.dellectus.usuario.Usuario;
import br.com.dellectus.usuario.UsuarioDAOHibernate;

public class TestLogin {
	Usuario usuario = new Usuario();
	Usuario u = new Usuario();
	UsuarioDAOHibernate uDao = new UsuarioDAOHibernate();

//	@Test
//	public void verificarLogin() {
//		u.setLogin("mari123");
//		usuario = uDao.buscarPorLogin(u.getLogin());
//		
//		if(usuario.getUsuario_id()!= null) {
//			System.out.println("Usuario encontrado: ");
//			System.out.println("Email: "+usuario.getEmail());
//			System.out.println("Senha: "+usuario.getSenha());
//		}	
//		
//	}

}
