package br.com.fiap.beans;

import java.util.Calendar;

public class Carro {

	//Constante
	private final static String EXEMPLO_TESTE = "teste";
	
	
	//public, private
	//Protected -> no mesmo pacote e nas filhas
	//default/package -> no mesmo pacote
	
	private String cor;
	
	private Transmissao cambio;
	private Calendar dataLancamento;
	
	public String getCor() {
		return this.cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}

	public Transmissao getCambio() {
		return cambio;
	}

	public void setCambio(Transmissao cambio) {
		this.cambio = cambio;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public static String getExemploTeste() {
		return EXEMPLO_TESTE;
	}
}
