package br.com.dellectus.moduloPagamento;

import java.util.List;

import org.hibernate.Session;

import br.com.dellectus.imposto.Imposto;

public class ModuloPagamentoDAOHibernate implements ModuloPagamentoDAO {
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(ModuloPagamento moduloPagamento) {
		this.session.save(moduloPagamento);
		
	}

	@Override
	public void atualizar(ModuloPagamento moduloPagamento) {
		this.session.update(moduloPagamento);
		
	}

	@Override
	public void excluir(ModuloPagamento moduloPagamento) {
		this.session.delete(moduloPagamento);
		
	}

	@Override
	public List<ModuloPagamento> listar() {
		return this.session.createCriteria(ModuloPagamento.class).list();
	}

}
