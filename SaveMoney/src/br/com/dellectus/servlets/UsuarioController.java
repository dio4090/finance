package br.com.dellectus.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dellectus.usuario.User;
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
    	
    }
}
