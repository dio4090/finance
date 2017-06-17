package br.com.dellectus.unidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.dellectus.estoque.Estoque;

@Entity
@Table(name="unidade")
public class Unidade {
	@Id
	@GeneratedValue
	private int unidade_id;
	@ManyToOne
	@JoinColumn(name="estoque_id")
	private Estoque estoque;
	private String tipo;
	private int armazenamento;
	
	public int getUnidade_id() {
		return unidade_id;
	}
	public void setUnidade_id(int unidade_id) {
		this.unidade_id = unidade_id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getArmazenamento() {
		return armazenamento;
	}
	public void setArmazenamento(int armazenamento) {
		this.armazenamento = armazenamento;
	}
}
