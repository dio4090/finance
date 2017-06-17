package br.com.dellectus.moduloRecebimento;

import java.util.List;

import org.hibernate.Session;

import br.com.dellectus.imposto.Imposto;

public class ModuloRecebimentoDAOHibernate implements ModuloRecebimentoDAO {
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(ModuloRecebimento moduloRecebimento) {
		this.session.save(moduloRecebimento);
		
	}

	@Override
	public void atualizar(ModuloRecebimento moduloRecebimento) {
		this.session.update(moduloRecebimento);
		
	}

	@Override
	public void excluir(ModuloRecebimento moduloRecebimento) {
		this.session.delete(moduloRecebimento);
		
	}

	@Override
	public List<ModuloRecebimento> listar() {
		return this.session.createCriteria(ModuloRecebimento.class).list();
	}

}
