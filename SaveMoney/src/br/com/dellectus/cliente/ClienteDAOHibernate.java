package br.com.dellectus.cliente;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.dellectus.util.HibernateUtil;

public class ClienteDAOHibernate implements ClienteDAO {
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Cliente c) {
		try {
	        Session session = null;
	        session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(c);
	        transaction.commit();
	        session.close();
	        
			} catch(Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		
	}

	@Override
	public void atualizar(Cliente cliente) {
		this.session.update(cliente);
	}

	@Override
	public void excluir(Cliente c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(c);
        transaction.commit();
        session.close();
		
	}

	@Override
	public List<Cliente> listar() {
	       List<Cliente> clienteList = new ArrayList();
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Query query = session.createQuery("From Cliente");
	        clienteList = query.list();
	        return clienteList;
	}

}
