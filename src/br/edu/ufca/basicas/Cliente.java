package br.edu.ufca.basicas;

import java.io.Serializable;

public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private int permissao = 0;
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public int getPermissao() {
		return permissao;
	}
}
