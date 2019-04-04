package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.impl.ReservaDAOImpl;

class ReservaDAOTeste {

	private static ReservaDAO dao;
	
	@BeforeAll
	private static void iniciar() {
		dao = new ReservaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	@Test
	void test() {
		
		dao.listar();
		
		fail("Not yet implemented");
	}

}
