package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.beans.Veiculo;
import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.exception.CommitException;

public class VeiculoDAOImpl implements VeiculoDAO{
	private EntityManager em;
	
	
	public VeiculoDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	

	public void cadastrar(Veiculo veiculo) {
		// TODO Auto-generated method stub
	
		em.persist(veiculo);
		
	}

	public void atualizar(Veiculo veiculo) {
		// TODO Auto-generated method stub
		
		em.merge(veiculo);
	
	}

	public void deletar(int codigo) {
		// TODO Auto-generated method stub
		
		Veiculo veiculo = em.find(Veiculo.class, codigo);
		
		em.remove(veiculo);
	
	}

	public Veiculo pesquisar(int codigo) {
		// TODO Auto-generated method stub
		
		return em.find(Veiculo.class, codigo);
		
	}

	public void commit() throws CommitException {
		// TODO Auto-generated method stub
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
