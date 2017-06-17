package br.com.dellectus.moduloRecebimento;

import java.util.List;

public interface ModuloRecebimentoDAO {
	public void salvar(ModuloRecebimento moduloRecebimento);
	public void atualizar(ModuloRecebimento moduloRecebimento);
	public void excluir(ModuloRecebimento moduloRecebimento);
	public List<ModuloRecebimento> listar();
}
