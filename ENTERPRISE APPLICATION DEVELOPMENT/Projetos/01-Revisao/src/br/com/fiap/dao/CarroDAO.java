package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.beans.Carro;

public interface CarroDAO {

	//Somente as assinaturas dos m�todos
	List<Carro> buscarCarros();
	void criarNeh(Carro carro);
	
}
