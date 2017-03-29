package com.vitormarcal.passbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vitormarcal.passbox.model.LocalCredenciado;
import com.vitormarcal.passbox.repository.LocaisCredenciados;

@Controller
@RequestMapping("/locaisCredenciados")
public class LocaisCredenciadosController {

	@Autowired
	private LocaisCredenciados locaisCredenciados;
	
	@GetMapping
	public ModelAndView listar(){
		ModelAndView modelAndView = new ModelAndView("ListaLocaisCredenciados");
		
		modelAndView.addObject("locaisCredenciados", locaisCredenciados.findAll());
		modelAndView.addObject("localCredenciado", new LocalCredenciado());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(LocalCredenciado localCredenciado){
		this.locaisCredenciados.save(localCredenciado);
		return "redirect:/locaisCredenciados";
	}
}
