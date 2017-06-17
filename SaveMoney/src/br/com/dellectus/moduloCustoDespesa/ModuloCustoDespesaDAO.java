package br.com.dellectus.moduloCustoDespesa;

import java.util.List;

public interface ModuloCustoDespesaDAO {
	public void salvar(ModuloCustoDespesa moduloCustoDespesa);
	public void atualizar(ModuloCustoDespesa moduloCustoDespesa);
	public void excluir(ModuloCustoDespesa moduloCustoDespesa);
	public List<ModuloCustoDespesa> listar();
}
