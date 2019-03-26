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
@Table(name="T_USUARIO")
@SequenceGenerator(name="usuario", sequenceName="SQ_T_USUARIO")
public class Usuario {

	@Id
	@Column(name="cd_usuario")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario")
	private int codigo;
	
	@Column(name="nm_usuario", length=50, nullable=false)
	private String nome;

	
	@ManyToMany(mappedBy="usuarios")
	private List<ItemTeste> itemTestes;
	
	

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
	
	
	
}
