package br.com.fiap.loja.bo;

import br.com.fiap.loja.beans.Camiseta;

public class EstoqueBO {
	
	public static Camiseta consultaProduto(int codigo) {
		
		switch (codigo) {
			case 401 :
				return new Camiseta(codigo, 25.00, 5, "CAMISETA BRANCA");
			case 402 :
				return new Camiseta(codigo, 20.00, 2, "CAMISETA ROSA");
			case 403:
				return new Camiseta(codigo, 15.00, 6, "CAMISETA PRETA");
			default:
				return new Camiseta(0, 0, 0, "PRODUTO NÃO ENCONTRADO");
		}
	}
	
}
