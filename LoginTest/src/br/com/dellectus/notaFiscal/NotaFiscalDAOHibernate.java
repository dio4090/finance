package br.com.dellectus.notaFiscal;

import java.util.List;

import org.hibernate.Session;

import br.com.dellectus.imposto.Imposto;

public class NotaFiscalDAOHibernate implements NotaFiscalDAO {
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(NotaFiscal notaFiscal) {
		this.session.save(notaFiscal);
		
	}

	@Override
	public void atualizar(NotaFiscal notaFiscal) {
		this.session.update(notaFiscal);
		
	}

	@Override
	public void excluir(NotaFiscal notaFiscal) {
		this.session.delete(notaFiscal);
		
	}

	@Override
	public List<NotaFiscal> listar() {
		return this.session.createCriteria(NotaFiscal.class).list();
	}

}
