package br.com.senac.dominio;

import java.io.Serializable;

import javax.persistence.Entity;

import br.com.senac.dominio.enums.StatusPagamento;

@Entity
public class PagamentoComCartao extends Pagamento implements Serializable{
	
	
	public PagamentoComCartao() {
		
	}
	
	public PagamentoComCartao(Integer id, StatusPagamento statusPagamento, Pedido pedido, Integer numeroDeParcelas) {
		super(id, statusPagamento, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
}
