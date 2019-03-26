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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ITEM_TESTE")
@SequenceGenerator(name="itemTeste", sequenceName="SQ_T_ITEM_TESTE", allocationSize=1)
public class ItemTeste {

	@Id
	@Column(name="cd_item_teste")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="itemTeste")
	private int codigo;
	
	@Column(name="ds_item_teste", length=150)
	private String descricao;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_caso_teste")
	private CasoTeste casoTeste;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="T_ITEM_TESTE_USUARIO", joinColumns = @JoinColumn(name="cd_item_teste"), inverseJoinColumns = @JoinColumn(name="cd_usuario"))
	private List<Usuario> usuarios;
	
	
	public ItemTeste() {
		super();
	}

	public ItemTeste(String descricao) {
		super();
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CasoTeste getCasoTeste() {
		return casoTeste;
	}

	public void setCasoTeste(CasoTeste casoTeste) {
		this.casoTeste = casoTeste;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
