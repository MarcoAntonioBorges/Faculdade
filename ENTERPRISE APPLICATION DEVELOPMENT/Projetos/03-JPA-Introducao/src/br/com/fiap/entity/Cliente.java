package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="T_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName="SQ_T_CLIENTE", allocationSize=1)
public class Cliente {

	@Id
	@GeneratedValue(generator="cliente",strategy=GenerationType.SEQUENCE)
	@Column(name="cd_cliente")
	private int codigo;
	
	@Column(name="nm_cliente", length=100, nullable=false)
	private String nome;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar datanascimento;
	
	@Column(name="nr_cpf", length=14)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero", nullable=false)
	private Genero genero;
	
	
	@Column(updatable=false, name="dt_cadastro")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Calendar dataCadastro;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Column(name="st_vip")
	private boolean isVip;
	
	@Transient
	private long numeroCartao;

	
	
	/* Constructor empty */
	public Cliente() {
		super();
	}

	
	
	public Cliente(int codigo, String nome, Calendar datanascimento, String cpf, Genero genero, byte[] foto,
			boolean isVip) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.datanascimento = datanascimento;
		this.cpf = cpf;
		this.genero = genero;
		this.foto = foto;
		this.isVip = isVip;
	}



	public Cliente(String nome, Calendar datanascimento, String cpf, Genero genero, byte[] foto, boolean isVip) {
		super();
		this.nome = nome;
		this.datanascimento = datanascimento;
		this.cpf = cpf;
		this.genero = genero;
		this.foto = foto;
		this.isVip = isVip;
	}

	
	
	/* GETTERS AND SETTERS  */
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

	public Calendar getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Calendar datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public boolean isVip() {
		return isVip;
	}

	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	public long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
	
	
}
