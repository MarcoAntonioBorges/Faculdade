package br.com.fiap.loja.singleton;

import java.io.IOException;
import java.util.Properties;

/* CLASSE SINGLETON */
public class PropertySingleton {

	private static Properties p;
	private static final String ARQ = "/arquivo.properties";
	
	public static Properties getInstance() {
		if(p == null) {
			try {
				p = new Properties();
				p.load(PropertySingleton.class.getResourceAsStream(ARQ));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
}
