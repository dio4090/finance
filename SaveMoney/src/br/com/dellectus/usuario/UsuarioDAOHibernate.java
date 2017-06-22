package br.com.dellectus.usuario;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
		this.session.update(usuario);
	}
	
	@Override
	public void excluir(User usuario) {
		this.session.delete(usuario);
	}

	public User carregar(Integer codigo) {
		return (User) this.session.get(User.class, codigo);
	}

	public List<User> listar() {
		return this.session.createCriteria(Usuario.class).list();
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
