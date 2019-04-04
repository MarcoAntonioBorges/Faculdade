package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.anotacao.Tabela;
import br.com.fiap.beans.Cliente;

public class Teste {

	public static void main(String[] args) {
		
		//Instanciar um cliente
		Cliente cli = new Cliente();
		
		
		
		//API Reflection para recuperar os métodos
		Method[] metodos = cli.getClass().getDeclaredMethods();
		for (int i = 0; i < metodos.length; i++) {
			System.out.println(metodos[i].getName());
		}
		
		//SEPARAR MÉTODOS DE ATRIBUTOS
		System.out.println();
		
		//Recuperar os atributos
		Field[] atributos = cli.getClass().getDeclaredFields();
		for (Field field : atributos) {
			System.out.println(field.getName());
			//recuperar a anotação @Coluna
			Coluna anotacao = field.getAnnotation(Coluna.class);
			System.out.println("COLUNA: " + anotacao.nome());
			System.out.println("OBRIG.: " + anotacao.obrigatorio());
			System.out.println();
		}
		
		//Exibir o nome da classe
		System.out.println(cli.getClass().getName());
		 
		Tabela tbl = cli.getClass().getAnnotation(Tabela.class);
		System.out.println("SELECT * FROM " + tbl.nome());
		
	}
	
}
