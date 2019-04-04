package br.com.fiap.dao;

import br.com.fiap.beans.Motorista;
import br.com.fiap.exception.CommitException;

public interface MotoristaDAO {

	
	void cadastrar(Motorista motorista);
	
	void atualizar(Motorista motorista);
	
	void deletar(int codigo);
	
	Motorista pesquisar(int codigo);
	
	void commit() throws CommitException;
	
}
