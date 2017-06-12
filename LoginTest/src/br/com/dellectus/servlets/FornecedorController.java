package br.com.dellectus.servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dellectus.fornecedor.Fornecedor;
import br.com.dellectus.fornecedor.FornecedorDAO;
import br.com.dellectus.fornecedor.FornecedorDAOHibernate;

public class FornecedorController extends HttpServlet { 
	Fornecedor fornecedor = new Fornecedor();
	FornecedorDAOHibernate fornecedorDaoHibernate = new FornecedorDAOHibernate();
	FornecedorDAO fornecedorDAO;
	

	  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("addFornecedor")!=null){     	
        	
            String fRazaoSocial = request.getParameter("fRazaoSocial");
            String fCnpj = request.getParameter("fCnpj");
            String fEmail = request.getParameter("fEmail");
            String fEndereco = request.getParameter("fEndereco");
            String fTelefone = request.getParameter("fTelefone");
            
            
            
            fornecedor.setCnpj(fCnpj);
            fornecedor.setRazao_social(fRazaoSocial);;
            fornecedor.setEmail(fEmail);;
            fornecedor.setEndereco(fEndereco);;
            fornecedor.setTelefone(fTelefone);
            
            fornecedorDaoHibernate.salvar(fornecedor);
            
            RequestDispatcher rd = request.getRequestDispatcher("/fornecedor.jsp");
            rd.forward(request, response);
        }
          
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("showFornecedor")!=null){
            List<Fornecedor> fornecedorList = new ArrayList();
            fornecedorList = fornecedorDaoHibernate.listar();
            request.setAttribute("fornecedorList", fornecedorList);
            RequestDispatcher rd = request.getRequestDispatcher("show-fornecedor.jsp");
            rd.forward(request, response);
        }
         
          if(request.getParameter("updateFornecedor")!=null){
             int id1 = Integer.parseInt(request.getParameter("id"));
             String fRazaoSocial = request.getParameter("fRazaoSocial");
             String fCnpj = request.getParameter("fCnpj");
             String fEmail = request.getParameter("fEmail");
             String fEndereco = request.getParameter("fEndereco");
             String fTelefone = request.getParameter("fTelefone");
             String fnumberupdate = request.getParameter("fnumberupdate");
             fornecedorDaoHibernate.atualizar(fornecedor);
             
             RequestDispatcher rd = request.getRequestDispatcher("show-fornecedor.jsp");
             rd.forward(request, response);
             
         }
          
         if(request.getParameter("deleteFornecedor")!=null){
             int id2 = Integer.parseInt(request.getParameter("id"));
             fornecedor.setFornecedor_id(id2);
             fornecedorDaoHibernate.excluir(fornecedor);
              RequestDispatcher rd = request.getRequestDispatcher("show-fornecedor.jsp");
            rd.forward(request, response);
         }
      
    }

 
    @Override
    public String getServletInfo() {
        return "Este servelet é responsável pelo controle da calsse Dategoria: CRUD completo.";
    }// </editor-fold>
}
