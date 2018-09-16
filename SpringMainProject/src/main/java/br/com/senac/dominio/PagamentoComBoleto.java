package br.com.senac.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import br.com.senac.dominio.enums.StatusPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento implements Serializable {
	
	public PagamentoComBoleto() {
		super();
	}
	
	public PagamentoComBoleto(Integer id, StatusPagamento statusPagamento, Pedido pedido, Date dataVencimento,
			Date dataPagamento) {
		super(id, statusPagamento, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date dataVencimento;
	private Date dataPagamento;

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
