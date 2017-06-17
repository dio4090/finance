package br.com.dellectus.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dellectus.cliente.Cliente;
import br.com.dellectus.cliente.ClienteDAO;
import br.com.dellectus.cliente.ClienteDAOHibernate;

public class ClienteController extends HttpServlet {
	Cliente cliente =  new Cliente();
	ClienteDAOHibernate clienteDaoHibernate = new ClienteDAOHibernate();
	ClienteDAO clienteDAO;
	
       
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("addCliente")!=null){     	
        	
            String cRazaoSocial = request.getParameter("cRazaoSocial");
            String cCpf = request.getParameter("cCpf");
            String cEndereco = request.getParameter("cEndereco");
            String cTelefone = request.getParameter("cTelefone");
            
            
            
            cliente.setCpf(cCpf);
            cliente.setRazao_social(cRazaoSocial);
            cliente.setEndereco(cEndereco);
            cliente.setTelefone(cTelefone);
            
            clienteDaoHibernate.salvar(cliente);
            
            RequestDispatcher rd = request.getRequestDispatcher("/cliente.jsp");
            rd.forward(request, response);
        }
          
        
    }
	
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {	
    if(request.getParameter("showCliente")!=null){
        List<Cliente> clienteList = new ArrayList();
        clienteList = clienteDaoHibernate.listar();
        request.setAttribute("clienteList", clienteList);
        RequestDispatcher rd = request.getRequestDispatcher("show-cliente.jsp");
        rd.forward(request, response);
    }
     
      if(request.getParameter("updateCliente")!=null){
         int id1 = Integer.parseInt(request.getParameter("id"));
         String cRazaoSocial = request.getParameter("cRazaoSocial");
         String cCpf = request.getParameter("cCpf");
         String cEmail = request.getParameter("cEmail");
         String cEndereco = request.getParameter("cEndereco");
         String cTelefone = request.getParameter("cTelecone");
         String cnumberupdate = request.getParameter("cnumberupdate");
         clienteDaoHibernate.atualizar(cliente);
         
         RequestDispatcher rd = request.getRequestDispatcher("show-cliente.jsp");
         rd.forward(request, response);
         
     }
      
     if(request.getParameter("deleteCliente")!=null){
         int id2 = Integer.parseInt(request.getParameter("id"));
         cliente.setCliente_id(id2);
         clienteDaoHibernate.excluir(cliente);
          RequestDispatcher rd = request.getRequestDispatcher("show-cliente.jsp");
        rd.forward(request, response);
     }
}
}
