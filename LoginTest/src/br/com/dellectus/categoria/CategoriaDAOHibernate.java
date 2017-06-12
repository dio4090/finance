package br.com.dellectus.categoria;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.dellectus.util.HibernateUtil;

public class CategoriaDAOHibernate implements CategoriaDAO {
	
	@Override
	public void salvar(Categoria c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(c);
        transaction.commit();
        session.close();
	}

	@Override
	public void atualizar(Categoria c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Categoria newCategoria = (Categoria)session.load(Categoria.class, c.getCategoria_id());
        newCategoria.setCategoria_id(c.getCategoria_id());
        newCategoria.setNome(c.getNome());
        newCategoria.setProdutos(c.getProdutos());
        session.update(newCategoria);
        transaction.commit();
        session.close(); 
		
	}

	@Override
	public void excluir(Categoria c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(c);
        transaction.commit();
        session.close();
		
	}

	@Override
	public List<Categoria> listar() {
        List<Categoria> categoriaList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Categoria");
        categoriaList = query.list();
        return categoriaList;
	}

}
