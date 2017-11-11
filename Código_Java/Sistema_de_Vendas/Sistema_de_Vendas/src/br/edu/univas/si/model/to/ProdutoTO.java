package br.edu.univas.si.model.to;

public class ProdutoTO {

	private long codigoDeBarras; 		//PK
	private String descricao;
	private float precoVenda;
	private float quantidade;
	private String codigoUnidadeMedida; //FK
	
	
	public ProdutoTO(){
		
	}
	
	public ProdutoTO(long codigoDeBarras, String descricao, float precoVenda, float quantidade, String codigo_unidadeMedida) {
		
		this.codigoDeBarras = codigoDeBarras;
		this.descricao = descricao;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
		this.codigoUnidadeMedida = codigo_unidadeMedida;
	}
	
	public ProdutoTO(long codigoDeBarras, String descricao, float precoVenda, String codigo_unidadeMedida) {

		this.codigoDeBarras = codigoDeBarras;
		this.descricao = descricao;
		this.precoVenda = precoVenda;
		this.codigoUnidadeMedida = codigo_unidadeMedida;
	}

	public long getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(long codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public String getCodigo_unidadeMedida() {
		return codigoUnidadeMedida;
	}

	public void setCodigo_unidadeMedida(String codigo_unidadeMedida) {
		this.codigoUnidadeMedida = codigo_unidadeMedida;
	}
	
	
	
}
