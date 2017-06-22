package br.com.dellectus.usuario;

import java.util.List;

public interface UsuarioDAO {
	public void salvar(Usuario usuario);
	public void atualizar(Usuario usuario);
	public void excluir(Usuario usuario);
	public Usuario carregar(Integer codigo);
	public Usuario buscarPorLogin(Integer id);
	public List<Usuario> listar();
}
