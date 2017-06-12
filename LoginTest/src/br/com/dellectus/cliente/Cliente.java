package br.com.dellectus.cliente;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.dellectus.moduloRecebimento.ModuloRecebimento;
import br.com.dellectus.notaFiscal.NotaFiscal;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue
	private int cliente_id;
	@OneToMany(mappedBy="cliente", targetEntity = ModuloRecebimento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<ModuloRecebimento> moduloRecebimento;
	@OneToMany(mappedBy="cliente", targetEntity = NotaFiscal.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<NotaFiscal> notaFiscal;
	private String razao_social;
	@Column(length=11)
	private String cpf;
	@Column(length=15)
	private String telefone;
	private String endereco;
	
	
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getRazao_social() {
		return razao_social;
	}
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
