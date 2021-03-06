package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.Aluno;

@Repository
public interface AlunoRepositorio extends JpaRepository<Aluno, Integer>{
	
	Aluno findByNome (String nome);
	
	Aluno findByEmail (String email);

	Aluno findByNomeAndEmail(String nome, String email);
}
