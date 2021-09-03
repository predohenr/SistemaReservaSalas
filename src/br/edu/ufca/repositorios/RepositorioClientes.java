package br.edu.ufca.repositorios;

import java.util.ArrayList;
import br.edu.ufca.basicas.Cliente;

public class RepositorioClientes implements Repositorio{
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	RepositorioClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public boolean consultar(String cpf) {	
		for (int i = 0; i<this.clientes.size(); i++) {
			if(cpf.equals(this.clientes.get(i).getCpf())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void remover(String cpf) {
		Cliente cliente = retornaCliente(cpf);
		if (cliente!=null) {
			this.clientes.remove(cliente);
		}
	 }
	
	Cliente retornaCliente(String cpf) {	
		for (int i = 0; i<this.clientes.size(); i++) {
			if(cpf.equals(this.clientes.get(i).getCpf())) {
				return this.clientes.get(i);
			}
		}
		return null;
	}
	 
	//teste
	public static void main(String[] args) {
		Cliente a = Cliente.criarCliente();
		Cliente b = Cliente.criarCliente();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(a);
		clientes.add(b);
		RepositorioClientes repo = new RepositorioClientes(clientes);
		System.out.println(repo.consultar("2"));
		repo.remover("2");
		System.out.println(repo.consultar("2"));
	}
}