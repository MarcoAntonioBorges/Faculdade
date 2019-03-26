package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CasoTesteDAO;
import br.com.fiap.dao.SistemaDAO;
import br.com.fiap.dao.impl.CasoTesteDAOImpl;
import br.com.fiap.dao.impl.SistemaDAOImpl;
import br.com.fiap.entity.CasoTeste;
import br.com.fiap.entity.Sistema;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class TesteDAO {

	private static SistemaDAO sistemaDao;
	private static CasoTesteDAO casoTesteDao;
	
	
	@BeforeAll // Método que é executado antes de todos os testes
	private static void inicializar() {
		EntityManager em = EntityManagerFactorySingleton.getFabrica().createEntityManager();
		
		
		sistemaDao = new SistemaDAOImpl(em);
		casoTesteDao = new CasoTesteDAOImpl(em);
	}
	
	
	@Test
	void test() {
		Sistema sistema = new Sistema("FIAP");
		
		CasoTeste casoTeste1 = new CasoTeste("CASO01", "CASO DE TESTE 01");
		
		CasoTeste casoTeste02 = new CasoTeste("CASO02", "CASO DE TESTE 02");
		
		List<CasoTeste> casos = new ArrayList<CasoTeste>();
		casos.add(casoTeste1);
		casos.add(casoTeste02);
		
		
		sistema.setCasos(casos);
		
		
		// Pesquisa
		try {
			
			sistemaDao.cadastrar(sistema);
			sistemaDao.commit();
			
		
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("falha no teste");
		}
		
	}

}
