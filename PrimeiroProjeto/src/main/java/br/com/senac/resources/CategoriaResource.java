package br.com.senac.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.dominio.Categoria;
import br.com.senac.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService servicecat;
	
	@RequestMapping(method=RequestMethod.GET)
	public String testar() {
		
		return "ESTÁ FUNCIONANDO";
	}
	
	@RequestMapping(value="/{id}")
	public ResponseEntity<Categoria> find(@PathVariable Integer id){
		Categoria objCategoria = servicecat.buscar(id);
		return ResponseEntity.ok().body(objCategoria);
	}
}
