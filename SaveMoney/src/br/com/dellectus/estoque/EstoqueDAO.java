package br.com.dellectus.estoque;

import java.util.List;

public interface EstoqueDAO {
	public void salvar(Estoque estoque);
	public void atualizar(Estoque estoque);
	public void excluir(Estoque estoque);
	public List<Estoque> listar();
}
