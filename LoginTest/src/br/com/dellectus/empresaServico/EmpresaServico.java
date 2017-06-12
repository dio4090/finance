package br.com.dellectus.empresaServico;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.dellectus.moduloCustoDespesa.ModuloCustoDespesa;


@Entity
@Table(name="empresa_servico")
public class EmpresaServico {
	@Id
	@GeneratedValue
	private int empresa_servico_id;
	
	@ManyToMany
	@JoinTable(name="empresas_servicos", 
			   joinColumns={@JoinColumn(name="empresa_servico_id")},
			   inverseJoinColumns={@JoinColumn(name="servico_id")})
	List<EmpresaServico> empresaServico;
	
	@OneToMany(mappedBy="empresaServico", targetEntity = ModuloCustoDespesa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	private List<ModuloCustoDespesa> moduloCustosDespesas;
	@Column(length=14)
	private String cnpj;
	@Column(length=11)
	private String cpf;
	@Column(length=20)
	private String telefone;
	private String endereco;
	private String email;
	
	
	public int getEmpresa_servico_id() {
		return empresa_servico_id;
	}
	public void setEmpresa_servico_id(int empresa_servico_id) {
		this.empresa_servico_id = empresa_servico_id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
