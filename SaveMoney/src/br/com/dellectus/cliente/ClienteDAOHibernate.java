package br.com.dellectus.cliente;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.dellectus.util.HibernateUtil;

public class ClienteDAOHibernate implements ClienteDAO {
	
	@Override
	public void salvar(Cliente c) {
	    Session session = null;
	    Transaction tx=null;
	    try {
	        //session = this.sessionFactory.openSession();
	    	session = HibernateUtil.getSessionFactory().openSession();
	        tx = session.beginTransaction();
	        session.persist(c);
	        tx.commit();

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {

	     if (!tx.wasCommitted()) {
	     tx.rollback();
	     }//not much doing but a good practice
	     session.flush(); //this is where I think things will start working.
	     session.close();
	    }
	}

	@Override
	public void atualizar(Cliente c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Cliente newCliente = (Cliente)session.load(Cliente.class, c.getCliente_id());
        newCliente.setCliente_id(c.getCliente_id());
        newCliente.setRazao_social(c.getRazao_social());
        newCliente.setCpf(c.getCpf());
        newCliente.setEndereco(c.getEndereco());
        newCliente.setTelefone(c.getTelefone());
        session.update(newCliente);
        transaction.commit();
        session.close(); 
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
