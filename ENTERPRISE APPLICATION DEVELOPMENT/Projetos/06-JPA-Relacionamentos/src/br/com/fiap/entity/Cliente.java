package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName="SQ_T_CLIENTE", allocationSize=1)
public class Cliente {
	
	@Id
	@Column(name="cd_codigo")
	@GeneratedValue(generator="cliente", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	
	@OneToOne(mappedBy="cliente") /* mappedBy -> Atributo que mapeia a FK na classe Cliente */
	private CarrinhoCompras carrinho;
	
	@Column(name="nm_cliente", nullable=false, length=50)
	private String nome;
	
	@Column(name="ds_cpf", length=14)
	private String cpf;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
