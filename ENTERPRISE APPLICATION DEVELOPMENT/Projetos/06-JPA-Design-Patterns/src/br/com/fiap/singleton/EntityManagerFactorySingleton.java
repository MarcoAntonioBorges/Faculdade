package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	// 1 - Atributo est�tico que ser� �nico
	private static EntityManagerFactory fabrica;
	
	
	// 2 - Construtor privado
	private EntityManagerFactorySingleton() {}

	
	// 3 - M�todo est�tico que retona a �nica instancia
	public static EntityManagerFactory getFabrica() {
		if(fabrica == null) fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		return fabrica;
	}
	
}
