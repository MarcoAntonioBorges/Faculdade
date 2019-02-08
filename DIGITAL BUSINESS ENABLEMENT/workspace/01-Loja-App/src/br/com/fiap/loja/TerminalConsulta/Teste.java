package br.com.fiap.loja.TerminalConsulta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Teste {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		
		String[] camisetas = new String[]{"Camiseta branca", "Camiseta Azul", "Camiseta Rosa"};
		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int cod = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println();
		System.out.println("----- Bem Vindo! Data Atual: " + hoje.format(formatador));
		System.out.println();
		
		
		System.out.print("Digite o codigo: ");
		cod = teclado.nextInt();
		
		switch (cod) {
			case 401 :
				System.out.println(camisetas[0]);
			break;
			case 402 :
				System.out.println(camisetas[1]);
				break;
			case 403:
				System.out.println(camisetas[2]);
				break;
			default:
				System.out.println("Produto não encontrado");
				break;
		}
		
	}
}
