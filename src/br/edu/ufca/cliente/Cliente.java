package br.edu.ufca.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import br.edu.ufca.cliente.RepositorioClientes;
public class Cliente {
	private String nome;
	private String cpf;
	private float valor = 0; 
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public static Cliente criarCliente() {
		Cliente cliente = new Cliente();
	    String info = null; 
	    String nome = null, cpf = null;
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
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		return cliente;
	}
}
