package br.edu.ufca.basicas;

import java.util.ArrayList;

import br.edu.ufca.repositorios.RepositorioClientes;

@SuppressWarnings("unused")
public class Sala {
	String nome;
	int ocupada;
	private ArrayList<Sala> salas = new ArrayList<Sala>();
	
	private Sala() {
		this.ocupada = 0;
	}
	
	@SuppressWarnings("null")
	public void CriarSalas(int numsalas) {
		Sala a = new Sala() ;
		for (int i = 1;i<numsalas+1; i++) {
			a.nome = "Sala " + i;
			this.salas.add(a);
		}
	}
	
	public void AlugarSala(int sala) {
		
	}
	public void DevolverSala() {
		
	}
	public void Pagar() {
		
	}
	public static void main(String[] args) {
		Sala salas = new Sala();
		salas.CriarSalas(10);
	}
}
