package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CarrinhoCompraDAO;
import br.com.fiap.dao.GenericDAO;
import br.com.fiap.entity.CarrinhoCompras;

public class CarrinhoCompraDAOImpl extends GenericDAOImpl<CarrinhoCompras, Integer> implements CarrinhoCompraDAO{

	public CarrinhoCompraDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	
}

