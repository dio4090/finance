package br.com.dellectus.caixa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.dellectus.notaFiscal.NotaFiscal;

@Entity
@Table(name="caixa")
public class Caixa {
	@Id
	@GeneratedValue
	private int caixa_id;
	@OneToOne
	@JoinColumn(name="nota_fiscal_id")
	private NotaFiscal notaFiscal;
	@Column(precision=7, scale=2)
	private float montante;
	
	public int getCaixa_id() {
		return caixa_id;
	}
	public void setCaixa_id(int caixa_id) {
		this.caixa_id = caixa_id;
	}
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public float getMontante() {
		return montante;
	}
	public void setMontante(float montante) {
		this.montante = montante;
	}
}
