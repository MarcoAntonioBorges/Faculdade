package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.MercadoDAO;
import br.com.fiap.entity.Mercado;

public class MercadoDAOImpl extends GenericDAOImpl<Mercado, Integer> implements MercadoDAO {

	public MercadoDAOImpl(EntityManager em) {
		super(em);
	}

}
