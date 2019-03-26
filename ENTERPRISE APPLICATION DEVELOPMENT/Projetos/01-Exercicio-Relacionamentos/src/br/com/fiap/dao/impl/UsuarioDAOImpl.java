package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.entity.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO{

	public UsuarioDAOImpl(EntityManager em) {
		super(em);
	}

	
	
}
