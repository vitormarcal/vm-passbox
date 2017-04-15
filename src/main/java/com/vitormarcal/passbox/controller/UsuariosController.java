package com.vitormarcal.passbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitormarcal.passbox.model.Usuario;
import com.vitormarcal.passbox.repository.Usuarios;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	
	@Autowired
	private Usuarios usuarios;
		
	
	@GetMapping
	public ResponseEntity<List<Usuario>>listar(){
		return new ResponseEntity<List<Usuario>>(usuarios.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable("id") Usuario usuario){
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@PostMapping({"{id}", ""})
	public ResponseEntity<Usuario> salvar(@RequestBody@Validated Usuario usuario, Errors errors){
		Usuario usuarioBanco = this.usuarios.save(usuario);
		return new ResponseEntity<Usuario>(usuarioBanco, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id){
		usuarios.delete(id);
	}

}
