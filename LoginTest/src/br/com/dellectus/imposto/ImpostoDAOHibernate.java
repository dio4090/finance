package br.com.dellectus.imposto;

import java.util.List;

import org.hibernate.Session;

import br.com.dellectus.categoria.Categoria;

public class ImpostoDAOHibernate implements ImpostoDAO {
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Imposto imposto) {
		this.session.save(imposto);
		
	}

	@Override
	public void atualizar(Imposto imposto) {
		this.session.update(imposto);
		
	}

	@Override
	public void excluir(Imposto imposto) {
		this.session.delete(imposto);
		
	}

	@Override
	public List<Imposto> listar() {
		return this.session.createCriteria(Imposto.class).list();
	}

}
