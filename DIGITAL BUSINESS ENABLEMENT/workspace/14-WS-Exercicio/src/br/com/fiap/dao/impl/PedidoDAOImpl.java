package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.entity.Pedido;

public class PedidoDAOImpl extends GenericDAOImpl<Pedido, Integer> implements PedidoDAO	{

	public PedidoDAOImpl(EntityManager em) {
		super(em);
	}

}
