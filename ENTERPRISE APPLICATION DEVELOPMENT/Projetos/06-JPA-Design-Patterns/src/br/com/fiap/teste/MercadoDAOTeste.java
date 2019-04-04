package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.MercadoDAO;
import br.com.fiap.dao.impl.MercadoDAOImpl;
import br.com.fiap.entity.CategoriaMercado;
import br.com.fiap.entity.Mercado;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

class MercadoDAOTeste {

	private static MercadoDAO dao;
	
	@BeforeAll // Antes de todos os testes
	public static void init() {
		// Arrange
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");

		EntityManager em = factory.createEntityManager();

		dao = new MercadoDAOImpl(em);

	}
	
	@Test
	@DisplayName("Teste de busca DAO genérico")
	void buscarTest() {
		// Arrange - Instaciar as classes
		Mercado m = new Mercado("Andorinha", "Rua lins", CategoriaMercado.HIPER,
				new GregorianCalendar(1999, Calendar.APRIL, 1));

		
		
		// Act - Chamar o método que será testado
		try {

			dao.cadastrar(m);
			dao.commit();
		} catch (CommitException e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("Falha no commit");
		}
		
		Mercado mBuscado = new Mercado();
		try {
			mBuscado = dao.pesquisar(m.getCodigo());
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Codigo Inexistente");
		}
	
		
		
		//Assert
		assertNotNull(mBuscado);
		
	}

	@Test
	void test() {
		// Arrange - Instaciar as classes
		Mercado m = new Mercado("Andorinha", "Rua lins", CategoriaMercado.HIPER,
				new GregorianCalendar(1999, Calendar.APRIL, 1));

		// Act - Chamar o método que será testado
		try {

			dao.cadastrar(m);
			dao.commit();
		} catch (CommitException e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("Falha no commit");
		}

		// Assert - validar o resultado
		// o banco gerou um código para o mercado...
		assertNotEquals(0, m.getCodigo());

	}

}
