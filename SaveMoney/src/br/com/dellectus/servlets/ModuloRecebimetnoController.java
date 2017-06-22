package br.com.dellectus.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dellectus.cliente.Cliente;
import br.com.dellectus.cliente.ClienteDAOHibernate;
import br.com.dellectus.moduloRecebimento.ModuloRecebimento;
import br.com.dellectus.moduloRecebimento.ModuloRecebimentoDAOHibernate;
import br.com.dellectus.notaFiscal.NotaFiscal;
import br.com.dellectus.util.FinanceUtils;

public class ModuloRecebimetnoController extends HttpServlet {
	ModuloRecebimento mRecebimento = new ModuloRecebimento();
	FinanceUtils financeUtils = new FinanceUtils();
	
	ModuloRecebimentoDAOHibernate mDaoHibernate = new ModuloRecebimentoDAOHibernate();
	ClienteDAOHibernate cDaoHibernate = new ClienteDAOHibernate();
	
	Date data_integracao, data_pagamento = new Date();
	List<Cliente> clienteList = new ArrayList();
    
//	private void listNotaFiscal(HttpServletRequest request) {
//        notaFiscalList = new ArrayList();
//        notaFiscalList = nfDaoHibernate.listar();
//        request.setAttribute("notaFiscalList", notaFiscalList);
//	}
	
	private void listCliente(HttpServletRequest request) {
		clienteList = new ArrayList();
		clienteList = cDaoHibernate.listar();
		request.setAttribute("clienteList", clienteList);
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        if(request.getParameter("showClienteMR")!=null) {
        	listCliente(request);
       	
           RequestDispatcher rd = request.getRequestDispatcher("mod-recebimento.jsp");
           rd.forward(request, response);
        }
		
		if(request.getParameter("addModuloRecebimento") != null) {
			NotaFiscal nf = new NotaFiscal();
			Cliente c = new Cliente();
			
			try {
				int notaFiscalId = Integer.parseInt(request.getParameter("notaFiscal"));
				int clienteId = Integer.parseInt(request.getParameter("cliente"));
				data_pagamento = financeUtils.formataData(request.getParameter("dataPagamento"));
				
				//nf = nfDaoHibernate.getNotaFiscalById(notaFiscalId);
				c = cDaoHibernate.getClienteById(clienteId);
				
				//notaFiscalList.add(nf);
				
				//Pegar a data atual
				//Convertendo para Long
				data_integracao = Calendar.getInstance().getTime();
				
				//mRecebimento.setNotaFiscal(notaFiscalList);
				mRecebimento.setCliente(c);
				
				//Data de Cadastro do Mod. Recebimetno
				mRecebimento.setData_integacao(data_integracao);
				mRecebimento.setData_pagamento(data_pagamento);
				mRecebimento.setValor_total(nf.getValor_total_produto());
				
				mDaoHibernate.salvar(mRecebimento);
				
				RequestDispatcher rd = request.getRequestDispatcher("mod-recebimento.jsp");
	            rd.forward(request, response);
			} catch(Exception e) {
				System.out.println("Erro ao Salvar o Mod Recebimento: " + e.getMessage());
			}				
		}
		
	}
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    	
    }
}
