package br.edu.ufca.basicas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Funcionario extends Cliente{
	private static final long serialVersionUID = 1L;

	public Funcionario(String _nome, String _cpf) {
		super(_nome, _cpf);
	}
	
	public static Funcionario criarFuncionario() {
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
		Funcionario funcionario = new Funcionario(nome, cpf);
		funcionario.setPermissao(1);
		return funcionario;
	}
}
