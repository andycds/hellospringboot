package br.usjt.hellospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.hellospringboot.model.Aluno;
import br.usjt.hellospringboot.service.AlunosService;

@Controller
public class AlunosController {
//	@Autowired
//	private AlunosRepository alunosRepo;

	//	@Autowired
	//	public AlunosController(AlunosRepository alunosRepo) {
	//		this.alunosRepo = alunosRepo;
	//	}

//	@Autowired
//	public void setAlunosRepo(AlunosRepository alunosRepo) {
//		this.alunosRepo = alunosRepo;
//	}
	
	@Autowired
	private AlunosService alunosService;

	@GetMapping("/alunos")
	public ModelAndView listarAlunos() {
		//passe o nome da página ao construtor
		ModelAndView mv = new ModelAndView("lista_alunos");
		// Busque a coleção com o service
		List<Aluno> alunos = alunosService.listarTodos();
		//adicione a coleção ao objeto ModelAndView
		mv.addObject("alunos", alunos);
		mv.addObject(new Aluno());
		//devolva o ModelAndView
		return mv;
	}

	@PostMapping
	public String salvar(Aluno aluno) {
		// salvar usando o service
		alunosService.salvar(aluno);
		return "redirect:/alunos";
	}
}
