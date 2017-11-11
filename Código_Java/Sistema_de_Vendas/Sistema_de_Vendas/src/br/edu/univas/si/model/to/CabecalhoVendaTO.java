package br.edu.univas.si.model.to;

import java.util.Date;

public class CabecalhoVendaTO {

	private int numeroCupom;		//PK
	private String serieCupom;		//PK
	private Date dataEmissao;
	private float valorMercadoria;
	private String formaPagamento;
	private int cpfUsuario;			//FK
	private float valorDesconto;
	private float valorTotal;
	
	public CabecalhoVendaTO(int numeroCupom, String serieCupom, Date dataEmissao, float valorMercadoria,
						    String formaPagamento, int cpfUsuario, float valorDesconto, float valorTotal) {
		
		this.numeroCupom = numeroCupom;
		this.serieCupom = serieCupom;
		this.dataEmissao = dataEmissao;
		this.valorMercadoria = valorMercadoria;
		this.formaPagamento = formaPagamento;
		this.cpfUsuario = cpfUsuario;
		this.valorDesconto = valorDesconto;
		this.valorTotal = valorTotal;
	}

	public int getNumeroCupom() {
		return numeroCupom;
	}

	public void setNumeroCupom(int numeroCupom) {
		this.numeroCupom = numeroCupom;
	}

	public String getSerieCupom() {
		return serieCupom;
	}

	public void setSerieCupom(String serieCupom) {
		this.serieCupom = serieCupom;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public float getValorMercadoria() {
		return valorMercadoria;
	}

	public void setValorMercadoria(float valorMercadoria) {
		this.valorMercadoria = valorMercadoria;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public int getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(int cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public float getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(float valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
		
}
