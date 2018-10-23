package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Aluno;
import br.com.senac.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/validarAluno")
	public String login(Aluno aluno) {

		boolean validate = loginService.loginAluno(aluno);

		if (validate) {
			return "menu/paginaMenu.html";
		}
		return "erro/paginaErro.html";
	}

	@GetMapping("/login")
	public ModelAndView validarAluno() {
		ModelAndView mv = new ModelAndView("/menu/paginaLogin");
		mv.addObject("aluno", new Aluno());
		return mv;
	}

}
