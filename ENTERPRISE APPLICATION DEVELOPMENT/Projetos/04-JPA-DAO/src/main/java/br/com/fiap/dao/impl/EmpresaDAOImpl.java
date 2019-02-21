package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.entity.Empresa;
import br.com.fiap.exception.CommitException;

public class EmpresaDAOImpl implements EmpresaDAO{

	private EntityManager em;
	
	public EmpresaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public void cadastrar(Empresa emrpesa) {
		em.persist(emrpesa);
	}

	@Override
	public void atualizar(Empresa empresa) {
		em.merge(empresa);
	}

	@Override
	public void deletar(int codigo) {
		Empresa empresa = em.find(Empresa.class, codigo);
		em.remove(empresa);
	}

	@Override
	public Empresa pesquisar(int codigo) {
		return em.find(Empresa.class, codigo);
	}

	
	@Override
	public void commit() throws CommitException{
		try {
			em.getTransaction().begin();
			em.getTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}

	}
}
