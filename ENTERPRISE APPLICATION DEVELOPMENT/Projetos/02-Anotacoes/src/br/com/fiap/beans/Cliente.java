package br.com.fiap.beans;

import java.util.Calendar;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.anotacao.Tabela;

/*
 * TODA CLASSE HERDA DE OBJECT
 * */
@Tabela(nome="TBL_CLIENTE")
public class Cliente {
	@Coluna(nome="cd_cliente", obrigatorio = true)
	private int id;
	
	@Coluna(nome="nm_cliente", obrigatorio = true)
	private String nome;
	
	@Coluna(nome="dt_nasc", obrigatorio = true)
	private Calendar dataNascimento;
	
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
