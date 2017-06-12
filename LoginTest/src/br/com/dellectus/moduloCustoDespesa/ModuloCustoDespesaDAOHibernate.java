package br.com.dellectus.moduloCustoDespesa;

import java.util.List;

import org.hibernate.Session;

import br.com.dellectus.imposto.Imposto;

public class ModuloCustoDespesaDAOHibernate implements ModuloCustoDespesaDAO {
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(ModuloCustoDespesa moduloCustoDespesa) {
		this.session.save(moduloCustoDespesa);
		
	}

	@Override
	public void atualizar(ModuloCustoDespesa moduloCustoDespesa) {
		this.session.update(moduloCustoDespesa);
		
	}

	@Override
	public void excluir(ModuloCustoDespesa moduloCustoDespesa) {
		this.session.delete(moduloCustoDespesa);
		
	}

	@Override
	public List<ModuloCustoDespesa> listar() {
		return this.session.createCriteria(ModuloCustoDespesa.class).list();
	}

}
