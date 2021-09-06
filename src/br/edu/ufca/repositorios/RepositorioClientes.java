package br.edu.ufca.repositorios;

import java.io.Serializable;
import java.util.ArrayList;

import br.edu.ufca.basicas.Cliente;

public class RepositorioClientes implements Serializable{
	private static final long serialVersionUID = 1L;
	public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public RepositorioClientes() {
	}
	
	public boolean consultar(String cpf) {	
		for (int i = 0; i<this.clientes.size(); i++) {
			if(cpf.equals(this.clientes.get(i).getCpf())) {
				return true;
			}
		}
		return false;
	}

	public void remover(String cpf) {
	 }
	
	Cliente retornaCliente(String cpf) {	
		for (int i = 0; i<this.clientes.size(); i++) {
			if(cpf.equals(this.clientes.get(i).getCpf())) {
				return this.clientes.get(i);
			}
		}
		return null;
	}
}