package br.usjt.hellospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.hellospringboot.model.Aluno;
import br.usjt.hellospringboot.repository.AlunosRepository;

@Controller
public class AlunosController {
	@Autowired
	private AlunosRepository alunosRepo;

	@GetMapping ("/alunos")
	public ModelAndView listarAlunos () {
		//passe o nome da página ao construtor
		ModelAndView mv = new ModelAndView ("lista_alunos");
		//Busque a coleção com o repositório
		List <Aluno> alunos = alunosRepo.findAll();
		//adicione a coleção ao objeto ModelAndView
		mv.addObject("alunos", alunos);
		mv.addObject(new Aluno());
		//devolva o ModelAndView
		return mv;
	}

	@PostMapping
	public String salvar (Aluno aluno) {
		alunosRepo.save(aluno);
		return "redirect:/alunos";
	}
}
