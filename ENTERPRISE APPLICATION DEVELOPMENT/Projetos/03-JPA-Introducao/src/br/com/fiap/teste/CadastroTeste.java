package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;

public class CadastroTeste {

	public static void main(String[] args) {
		
		//CLIENTE_ORACLE
		
		//Criar um gerenciador de entidades:
		
		//Primeiro cria a fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		//Depois, a fabrica cria os Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		
		/*Instanciando o cliente*/
		Cliente cli = new Cliente("Marco A", new GregorianCalendar(2000, Calendar.MARCH, 2), "123.132.123-99", Genero.M, null, true);
		
		
		/* Cadastrar o cliente (Ainda não foi para o banco de dados) */
		em.persist(cli);
		
		/* Abre uma transação e finaliza com commit (Enviando para o banco de dados) */
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		//Fecha a fabrica e o Entity Manager
		em.close();
		fabrica.close();

	}

}
