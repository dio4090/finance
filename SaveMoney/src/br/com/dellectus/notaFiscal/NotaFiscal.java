package br.com.dellectus.notaFiscal;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.dellectus.cliente.Cliente;
import br.com.dellectus.fornecedor.Fornecedor;
import br.com.dellectus.imposto.Imposto;
import br.com.dellectus.moduloPagamento.ModuloPagamento;
import br.com.dellectus.moduloRecebimento.ModuloRecebimento;
import br.com.dellectus.produto.Produto;


@Entity
@Table(name="nota_fiscal")
public class NotaFiscal {
	@Id
	@GeneratedValue
	private int nota_fiscal_id;
	@OneToOne(mappedBy="notaFiscal")
	private ModuloPagamento moduloPagamento;
	@OneToOne(mappedBy="notaFiscal")
	private ModuloRecebimento moduloRecebimento;
	@ManyToOne
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor;
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@ManyToMany
	@JoinTable(name="nota_fiscal_produtos", 
			   joinColumns={@JoinColumn(name="nota_fiscal_id")},
			   inverseJoinColumns={@JoinColumn(name="produto_id")})
	List<Produto> produtos;
	
	@ManyToOne
	@JoinColumn(name="imposto_id")
	private Imposto imposto;
	@Column(precision=7, scale=2)
	private float valor_nota;
	private Date data_emissao;
	private Date data_vencimento;
	private int quantidade;
	@Column(precision=7, scale=2)
	private float valor_total_produto;
	
	
	//Getters And Setters
	public int getNota_fiscal_id() {
		return nota_fiscal_id;
	}
	public void setNota_fiscal_id(int nota_fiscal_id) {
		this.nota_fiscal_id = nota_fiscal_id;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Imposto getImposto() {
		return imposto;
	}
	public void setImposto(Imposto imposto) {
		this.imposto = imposto;
	}
	public float getValor_nota() {
		return valor_nota;
	}
	public void setValor_nota(float valor_nota) {
		this.valor_nota = valor_nota;
	}
	public Date getData_emissao() {
		return data_emissao;
	}
	public void setData_emissao(Date data_emissao) {
		this.data_emissao = data_emissao;
	}
	public Date getData_vencimento() {
		return data_vencimento;
	}
	public void setData_vencimento(Date data_vencimento) {
		this.data_vencimento = data_vencimento;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getValor_total_produto() {
		return valor_total_produto;
	}
	public void setValor_total_produto(float valor_total_produto) {
		this.valor_total_produto = valor_total_produto;
	}
	
	
}
