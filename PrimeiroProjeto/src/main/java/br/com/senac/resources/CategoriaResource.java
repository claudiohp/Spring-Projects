package br.com.senac.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mysql.fabric.Response;

import br.com.senac.dominio.Categoria;
import br.com.senac.dto.CategoriaDTO;
import br.com.senac.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService servicecat;
	
	/*
	@RequestMapping(method=RequestMethod.GET)
	public String testar() {
		
		return "ESTÁ FUNCIONANDO";
	}
	*/
	
	@RequestMapping(value="/{id}")
	public ResponseEntity<Categoria> find(@PathVariable Integer id){
		Categoria objCategoria = servicecat.buscar(id);
		return ResponseEntity.ok().body(objCategoria);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Categoria objCategoria){
		objCategoria = servicecat.inserir(objCategoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objCategoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> alterar (@RequestBody Categoria objCategoria,@PathVariable Integer id){
		objCategoria.setId(id);
		objCategoria = servicecat.alterar(objCategoria);
		
		return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir (@PathVariable Integer id){
		
		servicecat.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> listarCategoria(){
		
		List<Categoria> listarcategoria = servicecat.listarCategorias();
		
		List<CategoriaDTO> listDTO = listarcategoria.stream().map(categoria -> new CategoriaDTO(categoria)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
}
