package br.com.dellectus.produto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.List;

import br.com.dellectus.categoria.Categoria;
import br.com.dellectus.estoque.Estoque;
import br.com.dellectus.moduloCustoDespesa.ModuloCustoDespesa;
import br.com.dellectus.notaFiscal.NotaFiscal;

@Entity
@Table(name="produto")
public class Produto {
	@Id
	@GeneratedValue
	private int produto_id;
	@ManyToOne
	@JoinColumn(name="estoque_id")
	private Estoque estoque;

	@ManyToMany
	@JoinTable(name="custo_despesa_produtos", 
			   joinColumns={@JoinColumn(name="produto_id")},
			   inverseJoinColumns={@JoinColumn(name="modulo_custo_despesa_id")})
	List<ModuloCustoDespesa> moduloCustoDespesas;
	
	@ManyToMany
	@JoinTable(name="nota_fiscal_produtos", 
			   joinColumns={@JoinColumn(name="produto_id")},
			   inverseJoinColumns={@JoinColumn(name="nota_fiscal_id")})
	List<NotaFiscal> notaFiscal;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	private String nome;
	@Column(precision=7, scale=2)
	private float valor;
		
	
	//Getters And Setters
	public int getProduto_id() {
		return produto_id;
	}
	
	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public List<ModuloCustoDespesa> getModuloCustoDespesas() {
		return moduloCustoDespesas;
	}

	public void setModuloCustoDespesas(List<ModuloCustoDespesa> moduloCustoDespesas) {
		this.moduloCustoDespesas = moduloCustoDespesas;
	}

	public List<NotaFiscal> getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(List<NotaFiscal> notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setProduto_id(int produto_id) {
		this.produto_id = produto_id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
}
