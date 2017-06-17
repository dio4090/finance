package br.com.dellectus.fornecedor;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.dellectus.moduloPagamento.ModuloPagamento;
import br.com.dellectus.notaFiscal.NotaFiscal;


@Entity
@Table(name="fornecedor")
public class Fornecedor {
	
	@Id
	@GeneratedValue
	private int fornecedor_id;
	@OneToMany(mappedBy="fornecedor", targetEntity = ModuloPagamento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<ModuloPagamento> moduloPagamento;
	@OneToMany(mappedBy="fornecedor", targetEntity = NotaFiscal.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<NotaFiscal> notaFiscal;
	private String razao_social;
	@Column(length=20)
	private String cnpj;
	@Column(length=20)
	private String telefone;
	private String email;
	private String endereco;
	
	
	public int getFornecedor_id() {
		return fornecedor_id;
	}
	public void setFornecedor_id(int fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
	}
	public String getRazao_social() {
		return razao_social;
	}
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
