package br.com.fiap.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="T_VEICULO")
@Entity
@SequenceGenerator(name="veiculo", sequenceName="T_SQ_VEICULO", allocationSize=1)
public class Veiculo {
	
	@Id
	@Column(name="CD_VEICULO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int cod;
	
	@Column(name="DS_PLACA", length=9, nullable=false)
	private String placa;
	
	@Column(name="DS_COR", length=20, nullable=false)
	private String cor;
	
	@Column(name="NR_ANO", nullable=true)
	private int ano;

	
	
	
	public Veiculo() {
		super();
	}





	public Veiculo(int cod, String placa, String cor, int ano) {
		super();
		this.cod = cod;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}
	
	
	
	
	
	public Veiculo(String placa, String cor, int ano) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}





	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
}
