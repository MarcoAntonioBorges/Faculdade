package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="T_CARRINHO_COMPRA")
@SequenceGenerator(allocationSize=1, name="carrinho", sequenceName="SQ_T_CARRINHO")
public class CarrinhoCompras {
	
	@Id
	@Column(name="cd_carrinho")
	@GeneratedValue(generator="carrinho", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@OneToOne
	@JoinColumn(name="cd_cliente", nullable=false)
	private Cliente cliente;
	
	@OneToMany(mappedBy="carrinho")
	private List<ItemCarrinho> itemCarrinho;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_carrinho")
	private Calendar data;
	
	@Column(name="vl_total", nullable=false)
	private double valorTotal;

	
	
	
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}