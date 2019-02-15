package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		
		//CLIENTE_ORACLE
		
		//Criar um gerenciador de entidades:
		
		//Primeiro cria a fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		//Depois, a fabrica cria os Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Fecha a fabrica e o Entity Manager
		em.close();
		fabrica.close();

	}

}
