package br.com.dellectus.servico;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.dellectus.empresaServico.EmpresaServico;

@Entity
@Table(name="servico")
public class Servico {
	@Id
	@GeneratedValue
	private int servico_id;
	private String descricao_servico;
	
	@ManyToMany
	@JoinTable(name="empresas_servicos", 
			   joinColumns={@JoinColumn(name="servico_id")},
			   inverseJoinColumns={@JoinColumn(name="empresa_servico_id")})
	List<EmpresaServico> empresaServico;

	
	//Getters And Setters
	public int getServico_id() {
		return servico_id;
	}

	public void setServico_id(int servico_id) {
		this.servico_id = servico_id;
	}

	public String getDescricao_servico() {
		return descricao_servico;
	}

	public void setDescricao_servico(String descricao_servico) {
		this.descricao_servico = descricao_servico;
	}

	public List<EmpresaServico> getEmpresaServico() {
		return empresaServico;
	}

	public void setEmpresaServico(List<EmpresaServico> empresaServico) {
		this.empresaServico = empresaServico;
	}
	
}
