package br.com.fiap.beans;

import java.sql.Blob;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MOTORISTA")
public class Motorista {

	@Id
	@Column(name="NR_CARTEIRA", nullable=false)
	private int numeroCarteira;
	
	@Column(name="DS_NOME", nullable=false, length=150)
	private String nome;
	
	@Temporal(value=TemporalType.DATE)	
	@Column(name="DT_NASCIMENTO")
	private Calendar dataNascimento;
	
	@Lob
	@Column(name="FL_CARTEIRA")
	private Blob tipoCarteira;
	
	@Column(name="DS_GENERO")
	@Enumerated(EnumType.STRING)
	private Genero genero;

	
	public Motorista(String nome, Calendar dataNascimento, Blob tipoCarteira, Genero genero) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.tipoCarteira = tipoCarteira;
		this.genero = genero;
	}

	public Motorista(int numeroCarteira, String nome, Calendar dataNascimento, Blob tipoCarteira, Genero genero) {
		super();
		this.numeroCarteira = numeroCarteira;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.tipoCarteira = tipoCarteira;
		this.genero = genero;
	}

	public int getNumeroCarteira() {
		return numeroCarteira;
	}

	public void setNumeroCarteira(int numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Blob getTipoCarteira() {
		return tipoCarteira;
	}

	public void setTipoCarteira(Blob tipoCarteira) {
		this.tipoCarteira = tipoCarteira;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
	
}
