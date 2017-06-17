package br.com.dellectus.juros;

import java.util.List;

import org.hibernate.Session;

import br.com.dellectus.imposto.Imposto;

public class JurosDAOHibernate implements JurosDAO {
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Juros juros) {
		this.session.save(juros);
		
	}

	@Override
	public void atualizar(Juros juros) {
		this.session.update(juros);
		
	}

	@Override
	public void excluir(Juros juros) {
		this.session.delete(juros);
		
	}

	@Override
	public List<Juros> listar() {
		return this.session.createCriteria(Juros.class).list();
	}

}
