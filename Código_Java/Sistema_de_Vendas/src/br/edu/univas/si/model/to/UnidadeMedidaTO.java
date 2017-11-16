package br.edu.univas.si.model.to;

public class UnidadeMedidaTO {

	
	private String codigo;	//PK
	private String descricao;

	
	public UnidadeMedidaTO(String codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo(){
		return codigo;
	}
	
	public void setCodigo(String  codigo){
		this.codigo = codigo;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
}
