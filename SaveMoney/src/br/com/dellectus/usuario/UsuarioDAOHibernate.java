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
	public void salvar(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(usuario);
        transaction.commit();
        session.close();
	}

	public void atualizar(Usuario usuario) {
		this.session.update(usuario);
	}

	public void excluir(Usuario usuario) {
		this.session.delete(usuario);
	}

	public Usuario carregar(Integer codigo) {
		return (Usuario) this.session.get(Usuario.class, codigo);
	}

	public List<Usuario> listar() {
		return this.session.createCriteria(Usuario.class).list();
	}
	
	@Override
	public Usuario buscarPorLogin(Integer id) {
		Usuario u = new Usuario();
        try {        	
        	Session session = HibernateUtil.getSessionFactory().openSession();
            u =  (Usuario) session.get(Usuario.class, id);
        } catch (Exception e) {
        	return null;
        }
        
        return u;
	}
}
