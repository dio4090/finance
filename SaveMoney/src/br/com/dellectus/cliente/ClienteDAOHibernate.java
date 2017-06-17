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
	    Session session = null;
	    Transaction tx=null;
		 try {
			 System.out.println("");
			 System.out.println("-------------STATUS-------------");
			 System.out.println("ID: "+c.getCliente_id());
			 System.out.println("Nome: "+c.getRazao_social());
			 System.out.println("CPF:"+c.getCpf());
			 System.out.println("Endereco:"+c.getEndereco());
			 System.out.println("Telefone: "+c.getTelefone());
			 System.out.println("");
			 
			 session = HibernateUtil.getSessionFactory().openSession();
		     tx = session.beginTransaction();
	     	 session.update(c);
		     tx.commit();
		 }
		 catch (Exception e) {
		     if (tx!=null) tx.rollback();
		     throw e;
		 }
		 finally {
		     session.close();
		 }
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
