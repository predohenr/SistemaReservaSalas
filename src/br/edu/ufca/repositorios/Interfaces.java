package br.edu.ufca.repositorios;

interface Repositorio{
	boolean consultar(String cpf);
	void remover(String cpf);
}