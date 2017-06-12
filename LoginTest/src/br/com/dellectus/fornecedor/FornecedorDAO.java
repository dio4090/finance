package br.com.dellectus.fornecedor;

import java.util.List;

public interface FornecedorDAO {
	public void salvar(Fornecedor fornecedor);
	public void atualizar(Fornecedor fornecedor);
	public void excluir(Fornecedor fornecedor);
	public List<Fornecedor> listar();
}
