package br.com.dellectus.servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dellectus.categoria.Categoria;
import br.com.dellectus.categoria.CategoriaDAO;
import br.com.dellectus.categoria.CategoriaDAOHibernate;
import br.com.dellectus.produto.Produto;

public class CategoriaController extends HttpServlet {
	Categoria categoria = new Categoria();
	CategoriaDAOHibernate categoriaDaoHibernate = new CategoriaDAOHibernate();
	CategoriaDAO categoriaDAO;
	Produto produto = new Produto();

	  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("addCategoria")!=null){     	
        	
            String cNome = request.getParameter("cNome");
            //produto.setProduto_id(Integer.parseInt(request.getParameter("cProduto")));
            
            categoria.setNome(cNome);
            //categoria.getProdutos().add(produto);
            System.out.println("Categoria Nome: " + categoria.getNome());
            
            categoriaDaoHibernate.salvar(categoria);
            
            RequestDispatcher rd = request.getRequestDispatcher("categoria-add.jsp");
            rd.forward(request, response);
        }
          
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("showCategoria")!=null){
            List<Categoria> categoriaList = new ArrayList();
            categoriaList = categoriaDaoHibernate.listar();
            request.setAttribute("categoriaList", categoriaList);
            RequestDispatcher rd = request.getRequestDispatcher("categoria-list.jsp");
            rd.forward(request, response);
        }
         
          if(request.getParameter("updateCategoria")!=null){
             int id1 = Integer.parseInt(request.getParameter("id"));
             String ename = request.getParameter("ename");
             String enumberupdate = request.getParameter("enumberupdate");
             categoriaDaoHibernate.atualizar(categoria);
             
             RequestDispatcher rd = request.getRequestDispatcher("EmployeeAdd.jsp");
             rd.forward(request, response);
             
         }
          
         if(request.getParameter("deleteCategoria")!=null){
             int id2 = Integer.parseInt(request.getParameter("id"));
             categoria.setCategoria_id(id2);
             categoriaDaoHibernate.excluir(categoria);
              RequestDispatcher rd = request.getRequestDispatcher("categoria-add.jsp");
            rd.forward(request, response);
         }
      
    }

 
    @Override
    public String getServletInfo() {
        return "Este servelet é responsável pelo controle da calsse Dategoria: CRUD completo.";
    }// </editor-fold>
}
