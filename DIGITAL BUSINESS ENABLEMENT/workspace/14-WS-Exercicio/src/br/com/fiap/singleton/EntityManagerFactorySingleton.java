package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//1- atributo estático que será único
	private static EntityManagerFactory emf;
	
	//2- construtor vazio e privado
	private EntityManagerFactorySingleton() {}
	
	//3- método estático que retorna a única instancia
	public static EntityManagerFactory getInstance() {
		if (emf == null) {
			emf = Persistence
				.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return emf;
	}
	
}




