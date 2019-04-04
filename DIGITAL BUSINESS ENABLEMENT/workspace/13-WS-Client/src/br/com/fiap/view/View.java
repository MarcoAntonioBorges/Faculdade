package br.com.fiap.view;

import java.util.List;
import java.util.Scanner;

import br.com.fiap.exception.ResponseException;
import br.com.fiap.repository.EmpresaRepository;
import br.com.fiap.to.Empresa;

public class View {
	
	public static EmpresaRepository rep = new EmpresaRepository();

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("1 - Listar");
		System.out.println("2 - Pesquisar por codigo");
		System.out.println("3 - Cadastrar empresa");
		System.out.println("4 - Atualizar empresa");
		System.out.println("5 - Eliminar empresa");
		System.out.println("0 - Listar");
		int opcao = teclado.nextInt();
		
		switch (opcao) {
		case 1:
			listar();
			break;
		case 2:
			pesquisar(teclado);
			break;
		case 3:
			cadastrar(teclado);
			break;
		case 4:
			atualizar(teclado);
			
			break;
		case 5:
			remover(teclado);
			break;
		case 0:
			
			break;
		default:
			System.out.println("Opcao invalida");
			break;
		}
		
		teclado.close();
	}
	
	private static void atualizar(Scanner teclado) {
		int codigo = pegarCodigo(teclado);
		
		
		Empresa empresa = preencherEmpresa(teclado);
		
		try {
			rep.atualizar(empresa, codigo);
			System.out.println("Atualizado com sucesso");
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void cadastrar(Scanner teclado) {
		Empresa empresa = preencherEmpresa(teclado);
		
		try {
			rep.cadastrar(empresa);
			System.out.println("Criado com sucesso");
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void remover(Scanner teclado) {
		int codigo = pegarCodigo(teclado);
		
		try {
			rep.remover(codigo);
			System.out.println("Eliminado com sucesso");
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void listar() {
		
		try {
			List<Empresa> empresas = rep.listar();
			
			for (Empresa empresa : empresas) {
				System.out.println();
				System.out.println("------------------------------------------");
				System.out.println("Codigo.....: " + empresa.getCodigo());
				System.out.println("Nome.......: " + empresa.getNome());
				System.out.println("Faturamento: " + empresa.getFaturamento());
				System.out.println("Multicional: " + empresa.isMultinacional());
				System.out.println("------------------------------------------");
				System.out.println();
			}
			
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void pesquisar(Scanner teclado) {
		int codigo = pegarCodigo(teclado);
		
		try {
			Empresa empresa = rep.pesquisar(codigo);
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("Codigo.....: " + empresa.getCodigo());
			System.out.println("Nome.......: " + empresa.getNome());
			System.out.println("Faturamento: " + empresa.getFaturamento());
			System.out.println("Multicional: " + empresa.isMultinacional());
			System.out.println("------------------------------------------");
			System.out.println();
			
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int pegarCodigo(Scanner teclado) {
		System.out.print("Digite o codigo da empresa: ");
		int codigo = teclado.nextInt();
		return codigo;
	}
	
	private static Empresa preencherEmpresa(Scanner teclado) {
		Empresa empresa = new Empresa();
		System.out.println("Informe o nome da empresa: ");
		empresa.setNome(teclado.next() + teclado.nextLine());
		
		System.out.println("Informe o futaramento da empresa: ");
		empresa.setFaturamento(teclado.nextDouble());
		
		System.out.println("É multinacional? Sim/Nao");
		empresa.setMultinacional(teclado.next() != null ? true : false);
		return empresa;
	}
	
}
