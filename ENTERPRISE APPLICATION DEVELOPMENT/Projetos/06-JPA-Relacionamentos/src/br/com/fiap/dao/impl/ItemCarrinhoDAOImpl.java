package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ItemCarrinhoDAO;
import br.com.fiap.entity.ItemCarrinho;

public class ItemCarrinhoDAOImpl extends GenericDAOImpl<ItemCarrinho, Integer> implements ItemCarrinhoDAO{

	public ItemCarrinhoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
