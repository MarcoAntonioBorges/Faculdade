package br.com.fiap.loja.bo;


import org.apache.axis2.AxisFault;

import br.com.fiap.loja.beans.Camiseta;

public class EstoqueBO {
	
	public static Camiseta consultaProduto(int codigo) throws AxisFault{
		switch (codigo) {
			case 401 :
				return new Camiseta(codigo, 25.00, 5, "CAMISETA BRANCA");
			case 402 :
				return new Camiseta(codigo, 20.00, 2, "CAMISETA ROSA");
			case 403:
				return new Camiseta(codigo, 15.00, 6, "CAMISETA PRETA");
			default:
				throw new AxisFault("Produto não encontrado");
		}
	}
	
}
