package br.com.fiap.dao.impl;

import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public abstract class GenericDAOImpl<Tabela, Chave> implements GenericDAO<Tabela, Chave>{

	private EntityManager em;
	private Class<Tabela> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<Tabela>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(Tabela entidade) {
		
		
		em.persist(entidade);
		
	}

	@Override
	public void atualizar(Tabela entidade) {
		
		
		em.merge(entidade);
		
	}

	@Override
	public void excluir(Chave id) throws CodigoInexistenteException {
		
		
		Tabela tabela = pesquisar(id);
		
		if(tabela == null) throw new CodigoInexistenteException();
		
		
		em.remove(tabela);
		
	}

	@Override
	public Tabela pesquisar(Chave id) throws CodigoInexistenteException {
		
		Tabela tabela = em.find(clazz, id);
	
		if(tabela == null) throw new CodigoInexistenteException();
		
		return tabela;
	}

	@Override
	public void commit() throws CommitException {
		
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
