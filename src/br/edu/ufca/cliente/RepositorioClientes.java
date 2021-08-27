package br.edu.ufca.cliente;

public class RepositorioClientes {
	private Cliente[] clientes;
	
	public RepositorioClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}
	public boolean consultar(String cpf) {	
		for (int i = 0; i<this.clientes.length; i++) {
			if(cpf.equals(this.clientes[i].getCpf())) {
				return true;
			}
		}
		return false;
	}
	
	//teste consultar
	public static void main(String[] args) {
		Cliente a = Cliente.criarCliente();
		Cliente b = Cliente.criarCliente();
		Cliente[] clientes = {a, b};
		RepositorioClientes repo = new RepositorioClientes(clientes);
		System.out.println(repo.consultar("2"));
	}
}













/*
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	
	public boolean consultar() {
		System.out.print("Digite o cpf a ser buscado: "); 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	    String cpf = null;
	    try { 
	    	cpf = br.readLine(); 
	    } catch (IOException ioe) { 
	    	System.out.println("Erro!"); 
	        System.exit(1); 
	    } 
		for (int i = 0; i<this.clientes.length; i++) {
			if(cpf.equals(this.clientes[i].getCpf())) {
				return true;
			}
		}
		return false;
 */