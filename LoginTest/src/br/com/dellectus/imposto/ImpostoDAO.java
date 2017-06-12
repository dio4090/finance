package br.com.dellectus.imposto;

import java.util.List;

public interface ImpostoDAO {
	public void salvar(Imposto imposto);
	public void atualizar(Imposto imposto);
	public void excluir(Imposto imposto);
	public List<Imposto> listar();
}
