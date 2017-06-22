package br.com.dellectus.usuario;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.dellectus.cliente.Cliente;
import br.com.dellectus.util.HibernateUtil;

public class UsuarioDAOHibernate implements UsuarioDAO {
	private Session session;
	Usuario log = new Usuario();


	public void setSession(Session session) {
		this.session = session;
	}
	
    @Override
	public void salvar(User usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(usuario);
        transaction.commit();
        session.close();
	}
    
	@Override
	public void atualizar(User usuario) {
	    Session session = null;
	    Transaction tx=null;
		 try {
			 session = HibernateUtil.getSessionFactory().openSession();
		     tx = session.beginTransaction();
	     	 session.update(usuario);
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
	public void excluir(User usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(usuario);
        transaction.commit();
        session.close();
	}

	public User carregar(Integer codigo) {
		return (User) this.session.get(User.class, codigo);
	}

	public List<User> listar() {
	       List<User> usuarioList = new ArrayList();
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Query query = session.createQuery("From User");
	        usuarioList = query.list();
	        return usuarioList;
	}
	
	@Override
	public User buscarPorLogin(Integer id) {
		User u = new User();
        try {        	
        	Session session = HibernateUtil.getSessionFactory().openSession();
            u =  (User) session.get(User.class, id);
        } catch (Exception e) {
        	return null;
        }
        
        return u;
	}

}
