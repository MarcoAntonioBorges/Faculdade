package br.com.fiap.ws.dao;

import java.util.List;

public interface GenericDAO<T,K> {
	
	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	T buscar(K chave) ;
	
	void remover(K chave) throws Exception ;
	
	List<T> listar();
	
	void commit() throws Exception;
}
