package br.com.dellectus.unidade;

import java.util.List;

import org.hibernate.Session;

import br.com.dellectus.categoria.Categoria;

public class UnidadeDAOHibernate implements UnidadeDAO {
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Unidade unidade) {
		this.session.save(unidade);
		
	}

	@Override
	public void atualizar(Unidade unidade) {
		this.session.update(unidade);
		
	}

	@Override
	public void excluir(Unidade unidade) {
		this.session.delete(unidade);
		
	}

	@Override
	public List<Unidade> listar() {
		return this.session.createCriteria(Unidade.class).list();
	}

}
