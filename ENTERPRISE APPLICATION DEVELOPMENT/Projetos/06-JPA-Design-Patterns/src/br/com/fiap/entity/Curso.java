package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * 	T_CURSO (SQ_T_CURSO)
 * 		*cd_curso (NUMBER) (PK)
 * 		*nm_curso (VARCHAR (15))
 * 		*dt_lancamento (Date)
 * 		ds_categoria (VARCHAR2) (Enum: TECNICO, BACHAREL, POS) 
 * */

@Entity
@Table(name="T_CURSO")
@SequenceGenerator(name="curso", sequenceName="SQ_T_CURSO", allocationSize=1)
public class Curso {

	@Id
	@Column(name="cd_codigo")
	@GeneratedValue(generator="curso", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_curso", length=15, nullable=false)
	private String nome;
	
	@Column(name="dt_lancamento", nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Calendar dataLancamento;

	@Enumerated(EnumType.STRING)
	@Column(name="ds_categoria")
	private Categoria categoria;

	
	public Curso() {
		super();
	}

	public Curso(String nome, Calendar dataLancamento, Categoria categoria) {
		super();
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.categoria = categoria;
	}

	public Curso(int codigo, String nome, Calendar dataLancamento, Categoria categoria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.categoria = categoria;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
