package br.com.dellectus.produto;

import java.util.List;

import org.hibernate.Session;

public class ProdutoDAOHibernate implements ProdutoDAO {
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Produto produto) {
		this.session.save(produto);
		
	}

	@Override
	public void atualizar(Produto produto) {
		this.session.update(produto);
		
	}

	@Override
	public void excluir(Produto produto) {
		this.session.delete(produto);
		
	}

	@Override
	public List<Produto> listar() {
		return this.session.createCriteria(Produto.class).list();
	}
	
	
}
