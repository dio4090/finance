package br.com.dellectus.moduloCustoDespesa;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.dellectus.empresaServico.EmpresaServico;
import br.com.dellectus.produto.Produto;

@Entity
@Table(name="modulo_curstos_despesas")
public class ModuloCustoDespesa {
	@Id
	@GeneratedValue
	private int modulo_custo_despesa_id;
	@ManyToOne
	@JoinColumn(name="empresa_servico_id")
	EmpresaServico empresaServico;
	
	@ManyToMany
	@JoinTable(name="custo_despesa_produtos", 
			   joinColumns={@JoinColumn(name="modulo_custo_despesa_id")},
			   inverseJoinColumns={@JoinColumn(name="produto_id")})
	List<Produto> produtos;
	
	private String descricao;
	@Column(precision=7, scale=2)
	private float valor;
	private Date data_vencimento;
	
	
	
	//Getters And Setters
	public int getModulo_custo_despesa_id() {
		return modulo_custo_despesa_id;
	}
	public void setModulo_custo_despesa_id(int modulo_custo_despesa_id) {
		this.modulo_custo_despesa_id = modulo_custo_despesa_id;
	}
	public EmpresaServico getEmpresaServico() {
		return empresaServico;
	}
	public void setEmpresaServico(EmpresaServico empresaServico) {
		this.empresaServico = empresaServico;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Date getData_vencimento() {
		return data_vencimento;
	}
	public void setData_vencimento(Date data_vencimento) {
		this.data_vencimento = data_vencimento;
	}
	

}
