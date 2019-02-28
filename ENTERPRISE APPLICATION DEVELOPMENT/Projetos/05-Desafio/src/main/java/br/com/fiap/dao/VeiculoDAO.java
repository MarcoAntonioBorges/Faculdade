package br.com.fiap.dao;

import br.com.fiap.beans.Veiculo;
import br.com.fiap.exception.CommitException;

public interface VeiculoDAO {
	
	void cadastrar(Veiculo veiculo);
	
	void atualizar(Veiculo veiculo);
	
	void deletar(int codigo);
	
	Veiculo pesquisar(int codigo);
	
	void commit() throws CommitException;
	
}
