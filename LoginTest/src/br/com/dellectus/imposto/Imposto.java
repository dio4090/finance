package br.com.dellectus.imposto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.dellectus.notaFiscal.NotaFiscal;

@Entity
@Table(name="imposto")
public class Imposto {
	
	@Id
	@GeneratedValue
	private int imposto_id;
	@OneToMany(mappedBy="imposto", targetEntity = NotaFiscal.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<NotaFiscal> notaFiscal;
	private String tipo;
	private int aliquota;
	
	
	public int getImposto_id() {
		return imposto_id;
	}
	public void setImposto_id(int imposto_id) {
		this.imposto_id = imposto_id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getAliquota() {
		return aliquota;
	}
	public void setAliquota(int aliquota) {
		this.aliquota = aliquota;
	}
		
}
