package br.com.fiap.dao;

import br.com.fiap.entity.Empresa;
import br.com.fiap.exception.CommitException;

public interface EmpresaDAO {

	void cadastrar(Empresa emrpesa);
	
	void atualizar(Empresa empresa);
	
	void deletar(int codigo);
	
	Empresa pesquisar(int codigo);
	
	void commit() throws CommitException;
}
