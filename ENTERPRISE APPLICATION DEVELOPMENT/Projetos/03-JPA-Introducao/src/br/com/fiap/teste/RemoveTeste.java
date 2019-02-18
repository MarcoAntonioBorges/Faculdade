package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;

public class RemoveTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();
		
		//Remover o cliente de ID 2
		Cliente cli = em.find(Cliente.class, 2);
		em.remove(cli);
		
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
		fabrica.close();
	}

}
