package br.com.fiap.ws.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="T_VENDA")
@SequenceGenerator(name="venda", sequenceName="SQ_T_VENDA", allocationSize=1)
public class Venda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="venda")	
	@Column(name = "cd_venda")
	private int id;
	
	@Column(name="ds_venda",nullable=false,length=100)
	private String descricao;
	
	@Column(name="vl_venda",nullable=false)
	private float valor;
	
	@JsonFormat(pattern="dd/MM/yyyy") 
	@Column(name="dt_venda")
	private Calendar data;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
}