package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.Login;

@Repository
public interface LoginRepositorio extends JpaRepository<Login, Integer>{
	/*
	Login findByLogin(String username);
	*/
}
