package br.com.dellectus.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.dellectus.fornecedor.Fornecedor;
import br.com.dellectus.fornecedor.FornecedorDAOHibernate;

public class TestFornecedor {
	Fornecedor fornecedor = new Fornecedor();
	FornecedorDAOHibernate fDao = new FornecedorDAOHibernate();
	
	
	@Test
	public void cadastrarFornecedor() {
		try {			
			fornecedor.setCnpj("317487218");
			fornecedor.setEmail("teste3@gmail.com");
			fornecedor.setRazao_social("Sr. Teste");
			fornecedor.setEndereco("Rua 30");
			fornecedor.setTelefone("23843289");
			
			fDao.salvar(fornecedor);
		} catch(Exception e) {
			System.out.println("Erro ao inserir:" + e);
		} finally {
			if(fornecedor != null)
				fornecedor = new Fornecedor();
		}
	}
	
	@Test
	public void atualizarfornecedor() {
		try {
			fornecedor.setFornecedor_id(3);
			fornecedor.setCnpj("317487218");
			fornecedor.setEmail("casa_frios@gmail.com");
			fornecedor.setRazao_social("Casa dos Frios");
			fornecedor.setEndereco("Rua 30");
			fornecedor.setTelefone("2385543289");
			
			fDao.atualizar(fornecedor);
		} catch(Exception e) {
			System.out.println("Erro ao atualizar:" + e);
		} finally {
			if(fornecedor != null)
				fornecedor = new Fornecedor();
		}
	}

	
	@Test
	public void listarFornecedor() {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		fornecedores = fDao.listar();
		
		for(Fornecedor f: fornecedores){
			System.out.println("Id: "+f.getFornecedor_id());
			System.out.println("Email: "+f.getEmail());
			System.out.println("CNPJ: "+f.getCnpj());
			System.out.println("Telefone: "+f.getTelefone());
			System.out.println("Razão Social: "+f.getRazao_social());
			System.out.println("Endereço: "+f.getEndereco());
			
			fornecedor.setFornecedor_id(f.getFornecedor_id());
		}
 	}
	
	@Test
	public void deleteFornecedor() {
		try {
			fDao.excluir(fornecedor);
		} catch(Exception e) {
			System.out.println("Erro ao atualizar:" + e);
		} finally {
			if(fornecedor != null)
				fornecedor = new Fornecedor();
		}
	}
	
}
