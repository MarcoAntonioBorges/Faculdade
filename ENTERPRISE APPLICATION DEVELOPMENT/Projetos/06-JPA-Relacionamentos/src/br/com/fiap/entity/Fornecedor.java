package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_FORNECEDOR")
@SequenceGenerator(allocationSize=1, name="fornecedor", sequenceName="SQ_T_FORNECEDOR")
public class Fornecedor {

	@Id
	@Column(name="cd_fornecedor")
	@GeneratedValue(generator="fornecedor", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@ManyToMany(mappedBy="fornecedor")
	private List<Produto> produto;
	
	@Column(name="nm_fornecedor", nullable=false, length=50)
	private String nome;
	
	@Column(name="ds_cnpj", nullable=false, length=15)
	private String cnpj;

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	
}
