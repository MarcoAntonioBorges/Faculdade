package br.com.fiap.loja.TerminalConsulta;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;

import br.com.fiap.loja.bo.*;
import br.com.fiap.loja.bo.EstoqueBOStub.Camiseta;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultaProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultaProdutoResponse;

public class Teste {

	public static void main(String[] args) throws RemoteException {
		
		
		//log.warn("Programa iniciado");
		
		String[] camisetas = new String[]{"Camiseta branca", "Camiseta Azul", "Camiseta Rosa"};
		String nomeLoja = "FIAP";
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int cod = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println();
		System.out.println("----- " + nomeLoja + " Bem Vindo! Data Atual: " + hoje.format(formatador));
		System.out.println();
		
		
		System.out.print("Digite o codigo: ");
		cod = teclado.nextInt();
		
		teclado.close();
		
		EstoqueBOStub stub = new EstoqueBOStub();
		
		ConsultaProduto consulta = new ConsultaProduto();
		consulta.setCodigo(cod);

		ConsultaProdutoResponse response = stub.consultaProduto(consulta);
		
		
		Camiseta camiseta = response.get_return();
		
		System.out.println(camiseta.getAll());
		
		
		
		//System.out.println(EstoqueBO.consultaProduto(cod).getAll());
		
		
		//log.warn("Programa finalizado");
	}

}
