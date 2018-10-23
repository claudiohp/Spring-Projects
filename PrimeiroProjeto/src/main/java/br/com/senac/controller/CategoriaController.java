package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.service.CategoriaService;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listarCategorias")
	public ModelAndView listarCategorias() {
		ModelAndView mv = new ModelAndView("/paginaCategorias");
		mv.addObject("categorias",categoriaService.listarCategorias());
		return mv;
	}
	
}
