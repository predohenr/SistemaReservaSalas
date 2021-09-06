package br.edu.ufca.repositorios;

import java.io.Serializable;
import java.util.ArrayList;
import br.edu.ufca.basicas.Funcionario;

public class RepositorioFuncionarios implements Serializable {
	private static final long serialVersionUID = 1L;
	public ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	public RepositorioFuncionarios() {
	}
	
	public boolean consultar(String cpf) {	
		for (int i = 0; i<this.funcionarios.size(); i++) {
			if(cpf.equals(this.funcionarios.get(i).getCpf())) {
				return true;
			}
		}
		return false;
	}

	public void remover(String cpf) {
		Funcionario funcionario = retornaFuncionario(cpf);
		if (funcionario!=null) {
			this.funcionarios.remove(funcionario);
		}
	 }
	
	Funcionario retornaFuncionario(String cpf) {	
		for (int i = 0; i<this.funcionarios.size(); i++) {
			if(cpf.equals(this.funcionarios.get(i).getCpf())) {
				return this.funcionarios.get(i);
			}
		}
		return null;
	}
}
