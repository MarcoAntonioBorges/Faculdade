package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;

public class RefreshTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Atualiza o objeto com os valores do Banco		
		//Pesquisar um cliente
		Cliente cli = em.find(Cliente.class, 2);
		System.out.println("Valor do banco: " + cli.getNome());
		
		System.out.println();
			
		//Alterar o valor do nome no java
		cli.setNome("Wilson");
		System.out.println("Valor modificado: " + cli.getNome());	
		
		//Realiza o refresh
		em.refresh(cli);

		//Exibir o nome
		System.out.println("Nome apos o refresh " + cli.getNome());
		
		em.close();
		fabrica.close();
	}
	
}
