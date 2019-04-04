package br.com.fiap.loja.bo;

import org.apache.log4j.Logger;

import br.com.fiap.loja.beans.Camiseta;

public class EstoqueBO {
	private static Logger log = Logger.getLogger(EstoqueBO.class);
	
	public static Camiseta consultaProduto(int codigo) {
		String msg = "Entrou no codigo";
		switch (codigo) {
			case 401 :
				log.debug(msg + " 401");
				return new Camiseta(codigo, 25.00, 5, "CAMISETA BRANCA");
			case 402 :
				log.debug(msg + " 402");
				return new Camiseta(codigo, 20.00, 2, "CAMISETA ROSA");
			case 403:
				log.debug(msg + " 403");
				return new Camiseta(codigo, 15.00, 6, "CAMISETA PRETA");
			default:
				log.error("Produto não encontrado!, CODIGO=" + codigo);
				return new Camiseta(0, 0, 0, "PRODUTO NÃO ENCONTRADO");
		}
	}
	
}
