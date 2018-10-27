package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Curso;
import br.com.senac.exception.ObjectNotFoundException;
import br.com.senac.repositorio.CursoRepositorio;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepositorio repoCur;

	public List<Curso> listarTodosCursos() {
		return repoCur.findAll();
	}
	
	public Curso buscar(Integer id) {
		System.out.println(id);
		Optional<Curso> objCurso = repoCur.findById(id);
		return objCurso.orElseThrow(() -> new ObjectNotFoundException(
				"Curso não encontrada! id: "+ id +"tipo: "+ Curso.class.getName()));
		
	}
	
	public Curso adicionar(Curso objCurso) {
		objCurso.setId(null);
		return repoCur.save(objCurso);
	}
	
	public Curso alterar(Curso objCurso) {
		System.out.println(objCurso.getId());
		Curso objCursoEncontrado = buscar(objCurso.getId());
		objCursoEncontrado.setNome(objCurso.getNome());
		objCursoEncontrado.setPreco(objCurso.getPreco());
		objCursoEncontrado.setDescricao(objCurso.getDescricao());
		objCursoEncontrado.setCategorias(objCurso.getCategorias());
		return repoCur.save(objCursoEncontrado);
	}

	public void excluir(Integer id) {
		repoCur.deleteById(id);
	}
	
}
