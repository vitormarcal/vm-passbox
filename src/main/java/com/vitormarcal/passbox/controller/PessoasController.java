package com.vitormarcal.passbox.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vitormarcal.passbox.enums.GeneroEnum;
import com.vitormarcal.passbox.model.Pessoa;
import com.vitormarcal.passbox.repository.Pessoas;

@Controller
@RequestMapping("/pessoas")
public class PessoasController {

	private static final String CADASTRO_VIEW = "CadastroPessoa";
	
	@Autowired
	private Pessoas pessoas;
	
	@GetMapping
	public ModelAndView listar(){
		ModelAndView modelAndView = new ModelAndView("ListaPessoas");
	
		modelAndView.addObject("pessoas", pessoas.findAll());
		return modelAndView;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView(CADASTRO_VIEW);
		return modelAndView;
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Pessoa> edicao(@PathVariable("id") Pessoa pessoa){
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ModelAndView salvar(@Validated Pessoa pessoa, Errors errors){
		ModelAndView modelAndView = new ModelAndView();
		if(errors.hasErrors()){
			modelAndView.setViewName(CADASTRO_VIEW);
			modelAndView.addObject("pessoa", pessoa);
			return modelAndView;
		}
		this.pessoas.save(pessoa);
		modelAndView.setViewName("redirect:/pessoas");
		return modelAndView;
	}
	
	@ModelAttribute("generos")
	public List<GeneroEnum> todosGeneros(){
		return Arrays.asList(GeneroEnum.values());
	}
	
	@ModelAttribute("pessoa")
	public Pessoa getPessoa(){
		return new Pessoa();
	}
	
	
	
}
