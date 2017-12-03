package br.edu.univas.si.model.to;

public class ItensVendaTO {

	private int numeroCupom; // PFK
	private String serieCupom; // PFK
	private int item; // PK
	private String codigoDeBarras; // FK
	private float quantidade;
	private String codigoUnidadeMedida;
	private float valorUnitario;
	private float valorVenda;

	public ItensVendaTO(int numeroCupom, String serieCupom, int item, String codigoDeBaaras, float quantidade,
			String codigoUnidadeMedida, float valorUnitario ,float valorVenda) {

		this.numeroCupom = numeroCupom;
		this.serieCupom = serieCupom;
		this.item = item;
		this.codigoDeBarras = codigoDeBaaras;
		this.quantidade = quantidade;
		this.codigoUnidadeMedida = codigoUnidadeMedida;
		this.valorUnitario = valorUnitario;
		this.valorVenda = valorVenda;
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

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public String getCodigoUnidadeMedida() {
		return codigoUnidadeMedida;
	}

	public void setCodigoUnidadeMedida(String codigoUnidadeMedida) {
		this.codigoUnidadeMedida = codigoUnidadeMedida;
	}

	public float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	public float getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
}
