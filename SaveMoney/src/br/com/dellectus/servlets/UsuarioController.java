package br.com.dellectus.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dellectus.usuario.User;
import br.com.dellectus.usuario.Usuario;
import br.com.dellectus.usuario.UsuarioDAOHibernate;
import br.com.dellectus.util.FinanceUtils;
import br.com.dellectus.util.LoginService;

public class UsuarioController extends HttpServlet {
	User u;
	LoginService loginService;
	UsuarioDAOHibernate uDaoHibernate = new UsuarioDAOHibernate();
	FinanceUtils util = new FinanceUtils();
	
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

	}
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    	loginService = new LoginService();
    	
		if(request.getParameter("AddUsuario") != null) {
			u = new User();
			u.setFirstName(request.getParameter("nome"));
			u.setPassword(request.getParameter("password"));
			u.setEmail(request.getParameter("email"));
			u.setUserId(request.getParameter("usuario"));
			u.setProfile(request.getParameter("perfil"));
			
			uDaoHibernate.salvar(u);
			response.sendRedirect("usuario.jsp");
		}
		
		if(request.getParameter("showUsuario") != null) {
			//response.sendRedirect("show-usuario.jsp");
			
	         List<User> usuarioList = new ArrayList();
	         usuarioList = uDaoHibernate.listar();
	         request.setAttribute("usuarioList", usuarioList);
	         RequestDispatcher rd = request.getRequestDispatcher("show-usuario.jsp");
	         rd.forward(request, response);
		}
		
		if(request.getParameter("getLogin") != null) {
	        String userId = request.getParameter("login");   
	        String password = request.getParameter("password");
	        
	        boolean result = loginService.authenticateUser(userId, password);
	        User user = loginService.getUserByUserId(userId);
	        if(result == true){
	            request.getSession().setAttribute("user", user);      
	            if(user.getProfile().equals("Gerente"))
	            	response.sendRedirect("home-gerente.jsp");
	            else
	            	response.sendRedirect("home-colaborador.jsp");
	        }
	        else{
	            response.sendRedirect("login.jsp");
	        }
	        
	          if(request.getParameter("updateUsuario")!=null){
	        	  u = new User();
	              Long id1 = Long.parseLong(request.getParameter("id"));
                  u.setId(id1);
			      u.setFirstName(request.getParameter("nome"));
				  u.setPassword(request.getParameter("password"));
			      u.setEmail(request.getParameter("email"));
				  u.setUserId(request.getParameter("usuario"));
				  u.setProfile(request.getParameter("perfil"));
	              uDaoHibernate.atualizar(u);
	              
	 	         RequestDispatcher rd = request.getRequestDispatcher("show-usuario.jsp");
		         rd.forward(request, response);
	          }
	           
	          if(request.getParameter("deleteUsuario")!=null){
	        	  u = new User();
	        	  Long id2 = Long.parseLong(request.getParameter("id"));
	        	  u.setId(id2);
	              uDaoHibernate.excluir(u);
	              
	 	         RequestDispatcher rd = request.getRequestDispatcher("show-usuario.jsp");
		         rd.forward(request, response);
	          }
		}
    }
}
