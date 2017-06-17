package br.com.dellectus.unidade;

import java.util.List;

public interface UnidadeDAO {
	public void salvar(Unidade unidade);
	public void atualizar(Unidade unidade);
	public void excluir(Unidade unidade);
	public List<Unidade> listar();
}
