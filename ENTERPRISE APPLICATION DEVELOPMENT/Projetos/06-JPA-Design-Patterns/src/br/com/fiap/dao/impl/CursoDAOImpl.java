package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CursoDAO;
import br.com.fiap.entity.Curso;

public class CursoDAOImpl extends GenericDAOImpl<Curso, Integer> implements CursoDAO{

	public CursoDAOImpl(EntityManager em) {
		super(em);
	}
}
