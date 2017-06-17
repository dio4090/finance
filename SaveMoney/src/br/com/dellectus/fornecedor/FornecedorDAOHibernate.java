package br.com.dellectus.fornecedor;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.dellectus.util.HibernateUtil;


public class FornecedorDAOHibernate implements FornecedorDAO {
	
	@Override
	public void salvar(Fornecedor f) {	
		try {
	        Session session = null;
	        session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(f);
	        transaction.commit();
	        session.close();
	        
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	@Override
	public void atualizar(Fornecedor f) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Fornecedor newFornecedor = (Fornecedor)session.load(Fornecedor.class, f.getFornecedor_id());
        newFornecedor.setFornecedor_id(f.getFornecedor_id());
        newFornecedor.setRazao_social(f.getRazao_social());
        newFornecedor.setCnpj(f.getCnpj());
        newFornecedor.setEmail(f.getEmail());
        newFornecedor.setEndereco(f.getEndereco());
        newFornecedor.setTelefone(f.getTelefone());
        session.update(newFornecedor);
        transaction.commit();
        session.close(); 
		
	}

	@Override
	public void excluir(Fornecedor f) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(f);
        transaction.commit();
        session.close();
		
	}

	@Override
	public List<Fornecedor> listar() {
        List<Fornecedor> fornecedorList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Fornecedor");
        fornecedorList = query.list();
        return fornecedorList;
	}

}
