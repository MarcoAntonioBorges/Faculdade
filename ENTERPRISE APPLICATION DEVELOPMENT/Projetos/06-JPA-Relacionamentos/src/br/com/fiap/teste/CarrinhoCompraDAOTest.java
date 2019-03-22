package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.CarrinhoCompraDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.impl.CarrinhoCompraDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.CarrinhoCompras;
import br.com.fiap.entity.Cliente;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class CarrinhoCompraDAOTest {

	private static ClienteDAO clienteDao;
	private static CarrinhoCompraDAO carrinhoDao;
	
	
	@BeforeAll // Método que é executado antes de todos os testes
	private static void inicializar() {
		EntityManager em = EntityManagerFactorySingleton.getFabrica().createEntityManager();
		
		clienteDao = new ClienteDAOImpl(em);
		carrinhoDao = new CarrinhoCompraDAOImpl(em);
		
	}
	
	
	@Test
	void test() {
		Cliente cliente = new Cliente("Marco A", "446254498778");
		CarrinhoCompras carrinho = new CarrinhoCompras(cliente, 100);
		
		
		try {
			//clienteDao.cadastrar(cliente);
			carrinhoDao.cadastrar(carrinho);
			carrinhoDao.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
		assertNotEquals(0, cliente.getCodigo());
		assertNotEquals(0, carrinho.getCodigo());
		
		// Pesquisa
		try {
			CarrinhoCompras busca = carrinhoDao.pesquisar(carrinho.getCodigo());
			assertNotNull(busca);
			assertNotNull(busca.getCliente());
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("falha no teste");
		}
		
		
	}

}
