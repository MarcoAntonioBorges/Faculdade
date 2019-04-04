package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;

public abstract class GenericDAOImpl<T,K> 
				implements GenericDAO<T, K> {

	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) 
			getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entidade) {
		em.persist(entidade);
	}

	@Override
	public void alterar(T entidade) {
		em.merge(entidade);
	}

	@Override
	public T buscar(K codigo) throws CodigoInvalidoException {
		T entidade = em.find(clazz, codigo);
		if (entidade == null) {
			throw new CodigoInvalidoException();
		}
		return entidade;
	}

	@Override
	public void remover(K codigo) throws CodigoInvalidoException {
		T entidade = buscar(codigo);
		em.remove(entidade);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
		
	}

	@Override
	public List<T> listar() {
		return em.createQuery("from " + clazz.getName(),clazz).getResultList();
	}

	
	
}
