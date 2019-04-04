package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CASO_TESTE")
@SequenceGenerator(name="caso", sequenceName="SQ_T_CASO_TESTE", allocationSize=1)
public class CasoTeste {
	
	@Id
	@Column(name="cd_caso_teste")
	@GeneratedValue(generator="caso", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_caso_teste", length=50, nullable=false)
	private String nome;
	
	@Column(name="ds_caso_uso", length=150)
	private String descricao;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_sistema")
	private Sistema sistema;
	
	@OneToMany(mappedBy="casoTeste", cascade =  CascadeType.PERSIST)
	private List<ItemTeste> itemTestes;
	

	public void addItem(ItemTeste item) {
		// Adiciona o item na lista
		itemTestes.add(item);

		// Adiciona o carrinho no item
		item.setCasoTeste(this);
	}
	
	
	public CasoTeste(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public CasoTeste() {
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public List<ItemTeste> getItemTestes() {
		return itemTestes;
	}

	public void setItemTestes(List<ItemTeste> itemTestes) {
		this.itemTestes = itemTestes;
	}
	
	
	
}
