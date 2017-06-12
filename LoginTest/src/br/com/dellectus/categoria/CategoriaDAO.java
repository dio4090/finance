package br.com.dellectus.categoria;

import java.util.List;

public interface CategoriaDAO {
	public void salvar(Categoria categoria);
	public void atualizar(Categoria categoria);
	public void excluir(Categoria categoria);
	public List<Categoria> listar();
}
