package com.vitormarcal.passbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vitormarcal.passbox.model.Pessoa;
import com.vitormarcal.passbox.repository.Pessoas;

@Controller
@RequestMapping("/pessoas")
public class PessoasController {

	@Autowired
	private Pessoas pessoas;
	
	@GetMapping
	public ModelAndView listar(){
		ModelAndView modelAndView = new ModelAndView("ListaPessoas");
	
		modelAndView.addObject("pessoas", pessoas.findAll());
		modelAndView.addObject("pessoa", new Pessoa());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Pessoa pessoa){
		this.pessoas.save(pessoa);
		return "redirect:/pessoas";
	}
}
