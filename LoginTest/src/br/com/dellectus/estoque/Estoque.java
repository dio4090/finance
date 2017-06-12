package br.com.dellectus.estoque;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.dellectus.produto.Produto;
import br.com.dellectus.unidade.Unidade;

@Entity
@Table(name="estoque")
public class Estoque {
	@Id
	@GeneratedValue
	private int estoque_id;
	
	private String nome;
	
    @OneToMany(mappedBy = "estoque", targetEntity = Produto.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Produto> produtos;
	
	@OneToMany(mappedBy="estoque", targetEntity = Unidade.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Unidade> unidades;
	private int quantidade;
	
	
	public int getEstoque_id() {
		return estoque_id;
	}
	public void setEstoque_id(int estoque_id) {
		this.estoque_id = estoque_id;
	}	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<Unidade> getUnidades() {
		return unidades;
	}
	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
