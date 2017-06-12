package br.com.dellectus.moduloPagamento;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.dellectus.fornecedor.Fornecedor;
import br.com.dellectus.juros.Juros;
import br.com.dellectus.notaFiscal.NotaFiscal;

@Entity
@Table(name="modulo_pagamento")
public class ModuloPagamento {
	@Id
	@GeneratedValue
	private int modulo_pagamento_id;
	@OneToOne
	private NotaFiscal notaFiscal;
	@ManyToOne
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor;
	@ManyToOne
	@JoinColumn(name="juros_id")
	private Juros juros;
	private Date data_integacao;
	private Date data_pagamento;
	@Column(precision=7, scale=2)
	private float valor_total;
	
	
	//Getters And Setters
	public int getModulo_pagamento_id() {
		return modulo_pagamento_id;
	}
	public void setModulo_pagamento_id(int modulo_pagamento_id) {
		this.modulo_pagamento_id = modulo_pagamento_id;
	}
	public NotaFiscal getNotaFiascal() {
		return notaFiscal;
	}
	public void setNotaFiascal(NotaFiscal notaFiascal) {
		this.notaFiscal = notaFiascal;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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
	public Integer getModulo_custo_despesa_id() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
