package br.com.dellectus.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.dellectus.cliente.Cliente;
import br.com.dellectus.cliente.ClienteDAOHibernate;

public class TestCliente {
	Cliente cliente = new Cliente();
	ClienteDAOHibernate cDao = new ClienteDAOHibernate();

	
	@Test
	public void cadastrarCliente(){
		try {			
			cliente.setCpf("317487218");
			cliente.setRazao_social("Sr. Teste");
			cliente.setEndereco("Rua 30");
			cliente.setTelefone("23843289");
			
			//cDao.salv0ar(cliente);
		} catch(Exception e) {
			System.out.println("Erro ao inserir:" + e);
		} finally {
			if(cliente != null)
				cliente = new Cliente();
		}
	}
	
	@Test
	public void atualizarCliente() {
		try {
			cliente.setCliente_id(2);
			cliente.setCpf("317487218");
			cliente.setRazao_social("Sr. Teste");
			cliente.setEndereco("Rua 30");
			cliente.setTelefone("23843289");
			
			cDao.atualizar(cliente);
		} catch(Exception e) {
			System.out.println("Erro ao atualizar:" + e);
		} finally {
			if(cliente != null)
				cliente = new Cliente();
		}
	}
	
	@Test
	public void listarCliente() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = cDao.listar();
		int i = 0;
		
		try {
			for(Cliente c: clientes) {		
				i++;
				System.out.println("Id: "+c.getCliente_id());
				System.out.println("CPF: "+c.getCpf());
				System.out.println("Telefone: "+c.getTelefone());
				System.out.println("Razão Social: "+c.getRazao_social());
				System.out.println("Endereço: "+c.getEndereco());
				
				cliente.setCliente_id(c.getCliente_id());
			}
			
		} catch(Exception e) {
			System.out.println("Erro ao listar:" + e);
		}
 	}
	
	@Test 
	public void deletarCliente() {
		try {
			cDao.excluir(cliente);
		} catch(Exception e) {
			System.out.println("Erro ao excluir:" + e);
		} finally {
			if(cliente != null)
				cliente = new Cliente();
		}
	}
}
