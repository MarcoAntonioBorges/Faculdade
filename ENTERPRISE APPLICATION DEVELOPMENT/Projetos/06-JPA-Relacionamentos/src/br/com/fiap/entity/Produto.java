package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="T_PRODUTO")
@SequenceGenerator(allocationSize=1, name="produto", sequenceName="SQ_T_PRODUTO")
public class Produto {

	@Id
	@Column(name="cd_produto")
	@GeneratedValue(generator="produto", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@OneToMany(mappedBy="produto")
	private List<ItemCarrinho> itemCarrinho;
	
	
	@Column(name="nm_produto", nullable=false, length=50)
	private String nome;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="T_PRODUTO_FORNECEDOR", joinColumns = @JoinColumn(name="cd_produto"), inverseJoinColumns = @JoinColumn(name="cd_fornecedor"))
	private List<Fornecedor> fornecedores;
	
	@Column(name="vl_produto", nullable=false)
	private double valor;	
	
	

	public Produto(String nome, List<Fornecedor> fornecedores, double valor) {
		super();
		this.nome = nome;
		this.fornecedores = fornecedores;
		this.valor = valor;
	}

	public Produto() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<ItemCarrinho> getItemCarrinho() {
		return itemCarrinho;
	}

	public void setItemCarrinho(List<ItemCarrinho> itemCarrinho) {
		this.itemCarrinho = itemCarrinho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	
}
