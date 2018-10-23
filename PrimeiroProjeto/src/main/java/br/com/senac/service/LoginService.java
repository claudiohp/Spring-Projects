package br.com.senac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Aluno;
import br.com.senac.repositorio.AlunoRepositorio;

@Service
public class LoginService {

	@Autowired
	private AlunoRepositorio alunorepositorio;
	
	public boolean loginAluno(Aluno aluno) {
		Aluno logarAluno = alunorepositorio.findByNomeAndEmail(aluno.getNome(), aluno.getEmail());

		if(logarAluno != null) {
			return false;
		}
		return true;
	}
}
