package com.vitormarcal.passbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitormarcal.passbox.model.Pessoa;
import com.vitormarcal.passbox.repository.Pessoas;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

	
	@Autowired
	private Pessoas pessoas;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listar(){
		return new ResponseEntity<List<Pessoa>>(pessoas.findAll(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Pessoa> edicao(@PathVariable("id") Pessoa pessoa){
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}
	
	
	@PostMapping("{id}")
	public ResponseEntity<Pessoa> salvar(@Validated Pessoa pessoa){
		Pessoa pessoaBanco = pessoas.save(pessoa);
		return new ResponseEntity<Pessoa>(pessoaBanco, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id){
		pessoas.delete(id);
	}
	
}
