package br.edu.univas.si.model.to;

import java.util.Date;

public class CabecalhoVendaTO {

	private int numeroCupom;		//PK
	private String serieCupom;		//PK
	private Date dataEmissao;
	private String cpfUsuario;			//FK
	private float valorTotal;
	
	public CabecalhoVendaTO(){
		
	}
	
	public CabecalhoVendaTO(int numeroCupom, String serieCupom, Date dataEmissao, String cpfUsuario, float valorTotal) {
		
		this.numeroCupom = numeroCupom;
		this.serieCupom = serieCupom;
		this.dataEmissao = dataEmissao;
		this.cpfUsuario = cpfUsuario;
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

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
		
}
