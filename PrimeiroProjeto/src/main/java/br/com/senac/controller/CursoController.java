package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Curso;
import br.com.senac.service.CategoriaService;
import br.com.senac.service.CursoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/adicionarCurso")
	public ModelAndView adicionarCurso() {
		ModelAndView mv = new ModelAndView("curso/paginaAdicionarCurso");
		mv.addObject("curso", new Curso());
		mv.addObject("categorias", categoriaService.listarCategorias());
		return mv;
	}
	
	@GetMapping("/listarCursos")
	public ModelAndView listaCursos() {
		ModelAndView mv = new ModelAndView("curso/paginaListarCurso");
		mv.addObject("cursos", cursoService.listarTodosCursos());
		return mv;
	}
	
	@PostMapping("/salvarCurso")
	public ModelAndView inserirCurso(Curso curso) {
		cursoService.adicionar(curso);
		return listaCursos();
	}
	
	@GetMapping("/excluirCurso/{id}")
	public ModelAndView excluirCurso(@PathVariable("id") Integer id) {
		cursoService.excluir(id);
		return listaCursos();
	}
	
	@GetMapping("/alterarCurso")
	public ModelAndView alterar(Curso curso) {
		cursoService.alterar(curso);
		return listaCursos();
	}
	
	@GetMapping("/alterarCurso/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("curso/paginaAlterarCurso");
		mv.addObject("curso", cursoService.buscar(id));
		return mv;
	}
	
	
	
}
