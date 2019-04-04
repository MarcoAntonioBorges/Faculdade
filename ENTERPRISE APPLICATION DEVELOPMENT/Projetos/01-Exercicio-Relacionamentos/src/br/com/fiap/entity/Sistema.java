package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_SISTEMA")
@SequenceGenerator(name="sistema", sequenceName="SQ_T_CLIENTE", allocationSize=1)
public class Sistema {

	@Id
	@Column(name="cd_codigo")
	@GeneratedValue(generator="sistema", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_sistema", length=50, nullable=false)
	private String nome;

	
	@OneToMany(mappedBy="casoTeste")
	private List<CasoTeste> casos;
	
	
	
//	public void addItem(CasoTeste item) {
//		// Adiciona o item na lista
//		casos.add(item);
//		
//		// Adiciona o carrinho no item
//		item.setSistema(this);
//	}
	
	
	public Sistema() {
		super();
	}

	public Sistema(String nome) {
		super();
		this.nome = nome;
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

	public List<CasoTeste> getCasos() {
		return casos;
	}

	public void setCasos(List<CasoTeste> casos) {
		this.casos = casos;
	}
	
	
	
}
