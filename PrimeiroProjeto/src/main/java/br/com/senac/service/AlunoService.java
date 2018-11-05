package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Aluno;
import br.com.senac.dominio.Curso;
import br.com.senac.exception.ObjectNotFoundException;
import br.com.senac.repositorio.AlunoRepositorio;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepositorio repoAlu;
	
	public Aluno inserir(Aluno objAluno) {
		objAluno.setId(null);
		return repoAlu.save(objAluno);
	}
	
	public List<Aluno> listarAlunos() {
		return repoAlu.findAll();
	}
	
	public Aluno buscar(Integer id) {
		Optional<Aluno> objAluno = repoAlu.findById(id);
		return objAluno.orElseThrow(() -> new ObjectNotFoundException(
				"Aluno não encontrado! id: "+ id +"Tipo: "+ Aluno.class.getName()));
		
	}
}
