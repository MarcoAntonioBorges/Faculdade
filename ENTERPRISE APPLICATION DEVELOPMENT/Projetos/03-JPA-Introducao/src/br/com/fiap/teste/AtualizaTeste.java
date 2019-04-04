package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;

public class AtualizaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		
		
		// Atualiza um  cliente
		
		// Instanciar um cliente com um Id que existe no banco de dados
		Cliente cli = new Cliente(2, "JHENIFFER", new GregorianCalendar(1970, Calendar.AUGUST, 2), "446.254.784-56", Genero.F, null, false);
		
		em.merge(cli);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
		fabrica.close();
	}

}
