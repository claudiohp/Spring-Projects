package br.com.senac.dominio;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Embeddable
public class ItemPedidoPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToMany
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	@ManyToMany
	@JoinColumn(name="curso_id")
	private Curso curso;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
