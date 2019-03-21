package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_EMPRESA")
@SequenceGenerator(name="empresa", sequenceName="SQ_T_EMPRESA", allocationSize=1)
public class Empresa {
	
	@Id
	@Column(name="cd_empresa")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="empresa")
	private int codigo;
	
	@Column(name="nm_empresa", length=50, nullable=false)
	private String nome;
	
	@Column(name="vl_faturamento")
	private double faturamento;
	
	@Column(name="ds_multinacional")
	private boolean multinacional;

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

	public double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}

	public boolean isMultinacional() {
		return multinacional;
	}

	public void setMultinacional(boolean multinacional) {
		this.multinacional = multinacional;
	}
	
	
}
