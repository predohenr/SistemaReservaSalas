package br.edu.ufca.basicas;

import java.io.Serializable;
import java.util.ArrayList;

public class Sala implements Serializable{
	private static final long serialVersionUID = 1L;
	public String nome;
	public boolean ocupada;
	public int numsalas = 10;
	public ArrayList<Sala> salas = new ArrayList<Sala>();
	
	public Sala() {
		this.ocupada = false;
	}

	public void criarSalas() {
		for (int i = 1;i<this.numsalas+1; i++) {
			Sala a = new Sala();
			a.nome = "Sala " + i;
			this.salas.add(a);
		}
	}
	
	public boolean AlugarSalaInt(int salavalor) {
		for (int i=0;i<this.numsalas;i++) {
			if (this.salas.get(salavalor-1).ocupada) {
				return false;
			}
			int num = Integer.parseInt(this.salas.get(i).nome.split(" ")[1]);
			if(salavalor == num) {
				this.salas.get(i).ocupada = true;
				return true;
			}
		}
		return false;
	}
	
	public boolean DevolverSalaInt(int salavalor) {
		for (int i=0;i<this.numsalas;i++) {
			if (!this.salas.get(salavalor-1).ocupada) {
				System.out.print("Só é possível devolver uma sala Alugada! \n");
				return false;
			}
			int num = Integer.parseInt(this.salas.get(i).nome.split(" ")[1]);
			if(salavalor == num) {;
				this.salas.get(i).ocupada = false;
				return true;
			}
		}
		return false;
	}
	
}
