package br.com.fiap.dao;

import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public interface GenericDAO<Tabela, Chave> {

	void cadastrar(Tabela entidade);
	
	void atualizar(Tabela entidade);
	
	void excluir(Chave id) throws CodigoInexistenteException;
	
	Tabela pesquisar(Chave id) throws CodigoInexistenteException;
	
	void commit() throws CommitException;
}
