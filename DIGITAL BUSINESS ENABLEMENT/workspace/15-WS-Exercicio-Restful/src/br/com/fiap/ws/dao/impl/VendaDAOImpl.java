package br.com.fiap.ws.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.ws.dao.VendaDAO;
import br.com.fiap.ws.entity.Venda;

public class VendaDAOImpl extends GenericDAOImpl<Venda, Integer> implements VendaDAO{

	public VendaDAOImpl(EntityManager em) {
		super(em);
	}

}
