package br.com.senac.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Pedido;
import br.com.senac.exception.ObjectNotFoundException;
import br.com.senac.repositorio.PedidoRepositorio;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepositorio repoPedido;

	public Pedido buscar(Integer id) {
		Optional<Pedido> objPedido = repoPedido.findById(id);
		return objPedido.orElseThrow(() -> new ObjectNotFoundException(
				"Pedido não encontrado! id: "+ id +"Tipo: "+ Pedido.class.getName()));
		
	}
	
	public Pedido inserir(Pedido objPedido) {
		objPedido.setId(null);
		return repoPedido.save(objPedido);
	}
	
	public Pedido alterar(Pedido objPedido) {
		Pedido objPedidoEncontrado = buscar(objPedido.getId());
		objPedidoEncontrado.setDataPedido(objPedido.getDataPedido());
		return repoPedido.save(objPedidoEncontrado);
	}

	public void excluir(Integer id) {
		repoPedido.deleteById(id);
	}
}
