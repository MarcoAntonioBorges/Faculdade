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


@Entity
@Table(name="T_MERCADO")
@SequenceGenerator(name="mercado", sequenceName="SQ_T_MERCADO", allocationSize=1)
public class Mercado {

	@Column(name="CD_MERCADO")
	@Id
	@GeneratedValue(generator="mercado", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="NM_MERCADO", length=50, nullable=false)
	private String nome;
	
	@Column(name="DS_ENDERECO")
	private String endereco;
	
	@Enumerated(EnumType.STRING)
	@Column(name="DS_CATEGORIA")
	private CategoriaMercado categoria;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_ABERTURA")
	private Calendar dataAbertura;

	
	
	
	public Mercado(String nome, String endereco, CategoriaMercado categoria, Calendar dataAbertura) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.categoria = categoria;
		this.dataAbertura = dataAbertura;
	}

	public Mercado(int codigo, String nome, String endereco, CategoriaMercado categoria, Calendar dataAbertura) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.categoria = categoria;
		this.dataAbertura = dataAbertura;
	}

	public Mercado() {
		super();
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public CategoriaMercado getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaMercado categoria) {
		this.categoria = categoria;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	
	
}
