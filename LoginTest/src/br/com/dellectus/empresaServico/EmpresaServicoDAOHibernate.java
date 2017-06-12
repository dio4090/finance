package br.com.dellectus.empresaServico;

import java.util.List;

import org.hibernate.Session;

public class EmpresaServicoDAOHibernate  implements EmpresaServicoDAO {
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(EmpresaServico empresaServico) {
		this.session.save(empresaServico);
		
	}

	@Override
	public void atualizar(EmpresaServico empresaServico) {
		this.session.update(empresaServico);
		
	}

	@Override
	public void excluir(EmpresaServico empresaServico) {
		this.session.delete(empresaServico);
		
	}

	@Override
	public List<EmpresaServico> listar() {
		return this.session.createCriteria(EmpresaServico.class).list();
	}
}
