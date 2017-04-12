package com.vitormarcal.passbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vitormarcal.passbox.model.Pessoa;
import com.vitormarcal.passbox.model.Usuario;
import com.vitormarcal.passbox.repository.Pessoas;
import com.vitormarcal.passbox.repository.Usuarios;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	private static final String CADASTRO_VIEW = "CadastroUsuario";
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private Pessoas pessoas;
	
	
	@GetMapping
	public ModelAndView listar(){
		ModelAndView modelAndView = new ModelAndView("ListaUsuarios");
		
		modelAndView.addObject("usuarios", usuarios.findAll());
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView salvar(@Validated Usuario usuario, Errors errors){
		ModelAndView modelAndView = new ModelAndView();
		if(errors.hasErrors()){
			modelAndView.setViewName(CADASTRO_VIEW);
			modelAndView.addObject("pessoa", usuario);
			return modelAndView;
		}
		this.usuarios.save(usuario);
		modelAndView.setViewName("redirect:/usuarios");
		return modelAndView;
	}
/*	
	@GetMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Usuario usuario){
		ModelAndView modelAndView = new ModelAndView(CADASTRO_VIEW);
		if(usuario.getPessoa() == null){
			usuario.setPessoa(new Pessoa());
		}
		modelAndView.addObject(usuario);
		return modelAndView;
	}*/
	
	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView(CADASTRO_VIEW);
		return modelAndView;
	}
	
	@ModelAttribute("usuario")
	public Usuario getUsuario(){
		return new Usuario();
	}
	
	@ModelAttribute("pessoas")
	public List<Pessoa> getPessoas(){
		return pessoas.findAll();
	}
}
