package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Estado;
import br.com.fiap.entity.Produto;

public class Exercicio {

	public static void main(String[] args) {
		/* REALIZAR O CRUD PARA O PRODUTO */
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();
		
		//Cadastrar
		Produto prod = new Produto("BOLACHA", 5, Estado.GRAMAS, new GregorianCalendar(2019, Calendar.AUGUST, 15), new GregorianCalendar(2019, Calendar.AUGUST, 1), 2, null);
		

		Produto prod2 = new Produto("MACARRÃO", 2, Estado.GRAMAS, new GregorianCalendar(2019, Calendar.AUGUST, 15), new GregorianCalendar(2019, Calendar.AUGUST, 1), 5, null);
		
		em.persist(prod);
		em.persist(prod2);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//READ
		Produto prodRead = em.find(Produto.class, 1);
		System.out.println(prodRead.getNome());
		
		
		//UPDATE
		Produto prodUpdate = new Produto(1, "LASANHA", 1, Estado.GRAMAS, new GregorianCalendar(2019, Calendar.AUGUST, 15), new GregorianCalendar(2019, Calendar.AUGUST, 1), 20, null);
		
		em.merge(prodUpdate);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		//DELETE
		Produto prodDelete = em.find(Produto.class, 2);
		em.remove(prodDelete);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
		fabrica.close();
		
	}

}
