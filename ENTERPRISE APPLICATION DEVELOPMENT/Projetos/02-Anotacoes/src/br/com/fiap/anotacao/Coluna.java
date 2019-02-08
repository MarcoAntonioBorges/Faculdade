package br.com.fiap.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) // ElementType.FIELD restringe a anota��o somente para atributos
public @interface Coluna {
	
	String nome();
	boolean obrigatorio();
	
}
