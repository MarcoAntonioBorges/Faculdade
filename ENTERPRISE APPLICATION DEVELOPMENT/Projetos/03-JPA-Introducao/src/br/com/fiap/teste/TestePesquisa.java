package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;

public class TestePesquisa {

	public static void main(String[] args) {
		// Pesquisar um cliente com codigo
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();
		
		//Busca o cliente
		Cliente cli = em.find(Cliente.class, 2);
		
		
		System.out.println(cli.getNome());

		
		cli.setNome("Francisco");
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

}
