package br.com.dellectus.juros;

import java.util.List;

public interface JurosDAO {
	public void salvar(Juros juros);
	public void atualizar(Juros juros);
	public void excluir(Juros juros);
	public List<Juros> listar();
}
