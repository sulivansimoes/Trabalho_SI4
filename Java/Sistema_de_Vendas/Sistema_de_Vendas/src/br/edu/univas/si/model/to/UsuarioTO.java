package br.edu.univas.si.model.to;

import br.edu.univas.si.model.util.Encryption;

public class UsuarioTO {

	private long cpf;		//PK
	private String nome;
	private boolean caixa;
	private boolean admnistrador;
	private String senha;
	
	public UsuarioTO(long cpf, String nome, boolean caixa, boolean gerente, String senha){
		this.cpf = cpf;
		this.nome = nome;
		this.caixa = caixa;
		this.admnistrador = gerente;
		this.senha = Encryption.encrypt(senha);
	}
	
	public UsuarioTO(long cpf, String nome, boolean caixa, boolean gerente){
		this.cpf = cpf;
		this.nome = nome;
		this.caixa = caixa;
		this.admnistrador = gerente;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isCaixa() {
		return caixa;
	}

	public void setCaixa(boolean caixa) {
		this.caixa = caixa;
	}

	public boolean isGerente() {
		return admnistrador;
	}

	public void setGerente(boolean gerente) {
		this.admnistrador = gerente;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
