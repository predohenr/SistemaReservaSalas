package br.edu.ufca.basicas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import br.edu.ufca.basicas.Cliente;
import br.edu.ufca.basicas.Funcionario;
import br.edu.ufca.repositorios.RepositorioClientes;
import br.edu.ufca.repositorios.RepositorioFuncionarios;

@SuppressWarnings("unused")
class Gerente {
	private String nome;
	private String cpf;
	private int permissao = 2;
	
	private Gerente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
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
