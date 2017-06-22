package br.com.dellectus.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dellectus.notaFiscal.NotaFiscalDAOHibernate;

public class NotaFiscalController extends HttpServlet {
	NotaFiscalDAOHibernate nfDaoHibernate = new NotaFiscalDAOHibernate();
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    }
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
