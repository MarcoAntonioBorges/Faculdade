package br.com.fiap.loja.view;

import java.rmi.RemoteException;
import java.util.Scanner;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.Camiseta;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultaProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultaProdutoResponse;

public class TerminalConsulta {

	public static void main(String[] args) throws RemoteException{
		
		//Instanciar a classe que chama o  web service (Stub)
		EstoqueBOStub stub = new EstoqueBOStub();
		
		Scanner teclado = new Scanner(System.in);

		System.out.print("Digite o codigo: ");
		//Ler o código
		int cod = teclado.nextInt();
		
		//Instaciar a classe que armazena o codigo que sera enviado
		ConsultaProduto consulta = new ConsultaProduto();
		
		// Seta o codigo para pesquisar
		consulta.setCodigo(cod);

		//Chamar o web service e recuperar o objeto que possui a resposta
		ConsultaProdutoResponse response = stub.consultaProduto(consulta);
		
		//Recupera e exibe os dados retornados pelo web service
		Camiseta camiseta = response.get_return();
		
		System.out.println(camiseta.getAll());
		
		
	}
	
	
}
