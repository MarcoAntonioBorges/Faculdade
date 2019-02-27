package br.com.fiap.loja.beans;

import java.io.Serializable;

public class Camiseta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private double preco;
	private int qtde;
	private String desc;
	
	public Camiseta() {
	}
	
	

	public Camiseta(int codigo, double preco, int qtde, String desc) {
		super();
		setCodigo(codigo);
		setPreco(preco);
		setQtde(qtde);
		setDesc(desc);
	}
	
	public String getAll() {
		return 	this.codigo + "\n" +
				this.preco + "\n" +
				this.qtde + "\n" +
				this.desc;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
