package br.com.dellectus.usuario;

import java.util.List;

public interface UsuarioDAO {
	public void salvar(User usuario);
	public void atualizar(User usuario);
	public void excluir(User usuario);
	public User carregar(Integer codigo);
	public User buscarPorLogin(Integer id);
	public List<User> listar();
}
