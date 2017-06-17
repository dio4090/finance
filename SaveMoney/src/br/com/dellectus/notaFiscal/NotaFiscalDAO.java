package br.com.dellectus.notaFiscal;

import java.util.List;

public interface NotaFiscalDAO {
	public void salvar(NotaFiscal notaFiscal);
	public void atualizar(NotaFiscal notaFiscal);
	public void excluir(NotaFiscal notaFiscal);
	public List<NotaFiscal> listar();
}
