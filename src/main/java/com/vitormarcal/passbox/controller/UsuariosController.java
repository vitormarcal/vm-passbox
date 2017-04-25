package com.vitormarcal.passbox.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vitormarcal.passbox.model.Usuario;
import com.vitormarcal.passbox.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuarioService usuarioService;
		
	@GetMapping
	public ResponseEntity<List<Usuario>> listar(){
		return new ResponseEntity<List<Usuario>>(this.usuarioService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable("id") Long id){
		Usuario usuario = this.usuarioService.findOne(id);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Validated Usuario usuario){
		Usuario usuarioBanco = this.usuarioService.save(usuario);
		
		URI location = ServletUriComponentsBuilder.
				fromContextPath(null)
				.path("/usuarios/{id}")
				.buildAndExpand(usuarioBanco.getId())
				.toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> alterar(@PathVariable("id") @RequestBody @Validated Usuario usuario){
		this.usuarioService.update(usuario);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
	}
	
	@DeleteMapping("{id}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		this.usuarioService.deleteUsuarioById(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
