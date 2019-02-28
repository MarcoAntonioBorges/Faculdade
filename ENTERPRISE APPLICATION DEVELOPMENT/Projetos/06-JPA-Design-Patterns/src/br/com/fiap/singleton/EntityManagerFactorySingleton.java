package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	// 1 - Atributo estático que será único
	private static EntityManagerFactory fabrica;
	
	
	// 2 - Construtor privado
	private EntityManagerFactorySingleton() {}

	
	// 3 - Método estático que retona a única instancia
	public static EntityManagerFactory getFabrica() {
		if(fabrica == null) fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		return fabrica;
	}
	
}
