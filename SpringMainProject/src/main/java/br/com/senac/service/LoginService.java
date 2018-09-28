package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Login;
import br.com.senac.repositorio.LoginRepositorio;

@Service
public class LoginService {

	@Autowired
	private LoginRepositorio loginrepositorio;
	
	/*
	public Login findByLogin (String username) {

		return loginrepositorio.findByLogin(username);
		
	}
	*/
}
