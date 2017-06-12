package br.com.dellectus.moduloPagamento;

import java.util.List;

public interface ModuloPagamentoDAO {
	public void salvar(ModuloPagamento moduloPagamento);
	public void atualizar(ModuloPagamento moduloPagamento);
	public void excluir(ModuloPagamento moduloPagamento);
	public List<ModuloPagamento> listar();
}
