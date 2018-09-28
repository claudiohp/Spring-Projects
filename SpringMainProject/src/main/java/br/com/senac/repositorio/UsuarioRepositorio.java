package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.Aluno;
import br.com.senac.dominio.Login;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Login, Integer>{
	
	/*
	Login findByLogin(String login);
	 */
}
