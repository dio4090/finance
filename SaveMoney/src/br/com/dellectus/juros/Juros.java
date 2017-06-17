package br.com.dellectus.juros;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.dellectus.moduloPagamento.ModuloPagamento;
import br.com.dellectus.moduloRecebimento.ModuloRecebimento;

@Entity
@Table(name="juros")
public class Juros {
	@Id
	@GeneratedValue
	private int juros_id;
	@OneToMany(mappedBy="juros", targetEntity = ModuloPagamento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<ModuloPagamento> moduloPagamento;
	@OneToMany(mappedBy="juros", targetEntity = ModuloRecebimento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<ModuloRecebimento> moduloRecebimento;
	private String categoria;
	private int valor;
	
	
	public int getJuros_id() {
		return juros_id;
	}
	public void setJuros_id(int juros_id) {
		this.juros_id = juros_id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
}
