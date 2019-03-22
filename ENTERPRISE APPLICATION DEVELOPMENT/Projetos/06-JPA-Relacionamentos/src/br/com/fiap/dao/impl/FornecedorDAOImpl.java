package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.FornecedorDAO;
import br.com.fiap.entity.Fornecedor;

public class FornecedorDAOImpl extends GenericDAOImpl<Fornecedor, Integer> implements FornecedorDAO{

	public FornecedorDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
