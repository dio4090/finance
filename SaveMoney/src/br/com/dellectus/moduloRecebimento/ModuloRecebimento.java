package br.com.dellectus.moduloRecebimento;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.dellectus.cliente.Cliente;
import br.com.dellectus.juros.Juros;
import br.com.dellectus.notaFiscal.NotaFiscal;

@Entity
@Table(name="modulo_recebimento")
public class ModuloRecebimento {
	@Id
	@GeneratedValue
	private int modulo_recebimento_id;
	@OneToOne
	@JoinColumn(name="nota_fiscal_id")
	private NotaFiscal notaFiscal;
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name="juros_id")
	private Juros juros;
	private Date data_integacao;
	private Date data_pagamento;
	@Column(precision=7, scale=2)
	private float valor_total;
	
	
	public int getModulo_recebimento_id() {
		return modulo_recebimento_id;
	}
	public void setModulo_recebimento_id(int modulo_recebimento_id) {
		this.modulo_recebimento_id = modulo_recebimento_id;
	}
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Juros getJuros() {
		return juros;
	}
	public void setJuros(Juros juros) {
		this.juros = juros;
	}
	public Date getData_integacao() {
		return data_integacao;
	}
	public void setData_integacao(Date data_integacao) {
		this.data_integacao = data_integacao;
	}
	public Date getData_pagamento() {
		return data_pagamento;
	}
	public void setData_pagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
	}
	public float getValor_total() {
		return valor_total;
	}
	public void setValor_total(float valor_total) {
		this.valor_total = valor_total;
	}
	
}
