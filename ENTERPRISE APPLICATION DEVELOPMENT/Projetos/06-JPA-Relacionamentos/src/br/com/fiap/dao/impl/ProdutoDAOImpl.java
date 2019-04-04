package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.entity.Produto;

public class ProdutoDAOImpl extends GenericDAOImpl<Produto, Integer> implements ProdutoDAO{

	public ProdutoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}

