package br.com.dellectus.categoria;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.dellectus.produto.Produto;

@Entity
@Table(name="categoria")
public class Categoria {
	@Id
	@GeneratedValue
	private int categoria_id;
	@OneToMany(mappedBy="categoria", targetEntity = Produto.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Produto> produtos;
	private String nome;

	
	//Getters And Setters
	public int getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
