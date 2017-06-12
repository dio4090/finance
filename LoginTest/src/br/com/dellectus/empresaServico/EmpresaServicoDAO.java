package br.com.dellectus.empresaServico;

import java.util.List;

public interface EmpresaServicoDAO {
	public void salvar(EmpresaServico empresaServico);
	public void atualizar(EmpresaServico empresaServico);
	public void excluir(EmpresaServico empresaServico);
	public List<EmpresaServico> listar();
}
