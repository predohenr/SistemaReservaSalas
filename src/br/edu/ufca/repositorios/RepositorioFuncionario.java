package br.edu.ufca.repositorios;

import java.util.ArrayList;
import br.edu.ufca.basicas.Funcionario;

public class RepositorioFuncionario implements Repositorio {
	private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	RepositorioFuncionario(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	@Override
	public boolean consultar(String cpf) {	
		for (int i = 0; i<this.funcionarios.size(); i++) {
			if(cpf.equals(this.funcionarios.get(i).getCpf())) {
				return true;
			}
		}
		return false;
	}

	@Override
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
	 
	//teste
	public static void main(String[] args) {
		Funcionario a = Funcionario.criarFuncionario();
		Funcionario b = Funcionario.criarFuncionario();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(a);
		funcionarios.add(b);
		RepositorioFuncionario repo = new RepositorioFuncionario(funcionarios);
		System.out.println(repo.consultar("2"));
		repo.remover("2");
		System.out.println(repo.consultar("2"));
	}
}
