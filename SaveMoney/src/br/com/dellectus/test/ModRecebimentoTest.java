package br.com.dellectus.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.dellectus.cliente.Cliente;
import br.com.dellectus.cliente.ClienteDAOHibernate;
import br.com.dellectus.moduloRecebimento.ModuloRecebimento;
import br.com.dellectus.moduloRecebimento.ModuloRecebimentoDAOHibernate;
import br.com.dellectus.notaFiscal.NotaFiscal;
import br.com.dellectus.notaFiscal.NotaFiscalDAOHibernate;
import br.com.dellectus.util.FinanceUtils;

public class ModRecebimentoTest {
	ModuloRecebimento mRecebimento = new ModuloRecebimento();
	FinanceUtils financeUtils = new FinanceUtils();
	
	ModuloRecebimentoDAOHibernate mDaoHibernate = new ModuloRecebimentoDAOHibernate();
	NotaFiscalDAOHibernate nfDaoHibernate = new NotaFiscalDAOHibernate(); 
	ClienteDAOHibernate cDaoHibernate = new ClienteDAOHibernate();
	
	Date data_integracao, data_pagamento = new Date();
	List<NotaFiscal> notaFiscalList = new ArrayList();
	
	@Test
	public void cadastrarModRecebimento() {
		NotaFiscal nf = new NotaFiscal();
		Cliente c = new Cliente();
		
		try {
			int notaFiscalId = 1;
			int clienteId = 3;
			
			nf = nfDaoHibernate.getNotaFiscalById(notaFiscalId);
			c = cDaoHibernate.getClienteById(clienteId);
			
			System.out.println("Nota Fiscal: "+nf.getNota_fiscal_id());
			System.out.println("Nota Fiscal: "+nf.getValor_total_produto());
			System.out.println("Cliente: "+c.getCliente_id());
			System.out.println("Cliente: "+c.getRazao_social());
			
			String timeStamp = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(Calendar.getInstance().getTime());
			//Pegar a data atual
			//Convertendo para Long
			data_integracao = Calendar.getInstance().getTime();
			data_pagamento = financeUtils.formataData("20/05/2017");
			
			System.out.println("Data de Integração: "+timeStamp);
			System.out.println("Data de Pagamento: "+data_pagamento);
			
			notaFiscalList.add(nf);
			
			//mRecebimento.setNotaFiscal(notaFiscalList);
			mRecebimento.setCliente(c);
			
			//Data de Cadastro do Mod. Recebimetno
			mRecebimento.setData_integacao(data_integracao);
			mRecebimento.setData_pagamento(data_pagamento);
			mRecebimento.setValor_total(nf.getValor_total_produto());
			
			mDaoHibernate.salvar(mRecebimento);
		} catch(Exception e) {
			System.out.println("Erro ao Salvar o Mod Recebimento: " + e.getMessage());
		}	
	}
}
