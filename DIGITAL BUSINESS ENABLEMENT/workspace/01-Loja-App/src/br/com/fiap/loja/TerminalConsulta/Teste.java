package br.com.fiap.loja.TerminalConsulta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.fiap.loja.bo.EstoqueBO;
import br.com.fiap.loja.singleton.PropertySingleton;

public class Teste {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		
		String[] camisetas = new String[]{"Camiseta branca", "Camiseta Azul", "Camiseta Rosa"};
		String nomeLoja = PropertySingleton.getInstance().getProperty("nome");
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern(PropertySingleton.getInstance().getProperty("mascara"));
		int cod = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println();
		System.out.println("----- " + nomeLoja + " Bem Vindo! Data Atual: " + hoje.format(formatador));
		System.out.println();
		
		
		System.out.print("Digite o codigo: ");
		cod = teclado.nextInt();
		
		System.out.println(EstoqueBO.consultaProduto(cod).getAll());
		
		teclado.close();
		
	}
}
