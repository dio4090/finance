package br.com.dellectus.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.dellectus.usuario.Usuario;
import br.com.dellectus.usuario.UsuarioDAOHibernate;

public class TestLogin {
	Usuario usuario = new Usuario();
	Usuario u = new Usuario();
	UsuarioDAOHibernate uDao = new UsuarioDAOHibernate();
	boolean resp;
	
	public void TestLogin (){
		 resp = false;
	}

	@Test
	public void verificarLogin() {
		u.setLogin("root");
		usuario = uDao.buscarPorLogin(u.getLogin());
		
		if(usuario.getCodigo() != null)
			resp = true;
		
		//Verificar o resultado esperado
		assertEquals(true, resp);
	}

}
