package br.edu.ufca.basicas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Cliente {
	private String nome;
	private String cpf;
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}

	public static Cliente criarCliente() {
	    String info = null, nome = null, cpf = null;
	    try { 
			System.out.print("Entre com o nome e o cpf no formato <NOME>,<CPF> (sem espacamento): "); 
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	    	info = br.readLine(); 
		    String[] arrSplit = info.split(",");
		    nome = arrSplit[0];
		    cpf = arrSplit[1];
	    } catch (IOException ioe) { 
	    	System.out.println("Erro ao ler as informações"); 
	        System.exit(1); 
	    } 
		Cliente cliente = new Cliente(nome, cpf);
		return cliente;
	}
}
