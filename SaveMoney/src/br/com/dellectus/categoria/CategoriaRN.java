package br.com.dellectus.categoria;

import java.util.List;

public class CategoriaRN implements CategoriaDAO {
	CategoriaDAOHibernate cDAOHibernate = new CategoriaDAOHibernate();

	@Override
	public void salvar(Categoria categoria) {
		cDAOHibernate.salvar(categoria);
	}

	@Override
	public void atualizar(Categoria categoria) {
		cDAOHibernate.atualizar(categoria);
		
	}

	@Override
	public void excluir(Categoria categoria) {
		cDAOHibernate.excluir(categoria);
		
	}

	@Override
	public List<Categoria> listar() {
		return cDAOHibernate.listar();
	}

}
