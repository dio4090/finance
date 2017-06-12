package br.com.dellectus.produto;

import java.util.List;

public interface ProdutoDAO {
	public void salvar(Produto produto);
	public void atualizar(Produto produto);
	public void excluir(Produto produto);
	public List<Produto> listar();
}
