package br.com.dellectus.cliente;

import java.util.List;

public interface ClienteDAO {
	public void salvar(Cliente cliente);
	public void atualizar(Cliente cliente);
	public void excluir(Cliente cliente);
	public List<Cliente> listar();
}
