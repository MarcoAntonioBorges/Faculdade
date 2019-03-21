package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.entity.Empresa;

public class EmpresaDAOImpl extends GenericDAOImpl<Empresa, Integer> implements EmpresaDAO{

	public EmpresaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	
}
