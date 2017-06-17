package br.com.dellectus.estoque;

import java.util.List;

import org.hibernate.Session;

public class EstoqueDAOHibernate implements EstoqueDAO {
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	public void salvar(Estoque estoque) {
		this.session.save(estoque);
		
	}

	@Override
	public void atualizar(Estoque estoque) {
		this.session.update(estoque);
		
	}

	@Override
	public void excluir(Estoque estoque) {
		this.session.delete(estoque);
		
	}

	@Override
	public List<Estoque> listar() {
		return this.session.createCriteria(Estoque.class).list();
	}
	
}
