package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ITEM_CARRINHO")
@SequenceGenerator(allocationSize=1, name="itemCarrinho", sequenceName="SQ_T_ITEM_CARRINHO")
public class ItemCarrinho {

	@Id
	@Column(name="cd_item_pedido")
	@GeneratedValue(generator="itemCarrinho", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name="cd_carrinho", nullable=false)
	private CarrinhoCompras carrinho;
	
	
	@ManyToOne
	@JoinColumn(name="cd_produto", nullable=false)
	private Produto produto;
	
	
	@Column(name="nr_quantidade", nullable=false)
	private int quantidade;
	
	@Column(name="vl_item_carrinho", nullable=false)
	private double valor;

	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
