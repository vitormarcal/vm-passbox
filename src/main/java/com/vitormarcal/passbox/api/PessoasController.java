package com.vitormarcal.passbox.api;

import java.net.URI;
import java.util.List;
import java.util.Set;

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

import com.vitormarcal.passbox.model.Pessoa;
import com.vitormarcal.passbox.model.Usuario;
import com.vitormarcal.passbox.service.PessoaService;
import com.vitormarcal.passbox.service.UsuarioService;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

	
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listar(){
		return new ResponseEntity<List<Pessoa>>(this.pessoaService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Pessoa> buscar(@PathVariable("id") Long id){
		Pessoa pessoa = this.pessoaService.findOne(id);
		return new ResponseEntity<>(pessoa, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Validated Pessoa pessoa){
		Pessoa pessoaBanco = this.pessoaService.save(pessoa);
		
		URI location = ServletUriComponentsBuilder.
				fromContextPath(null)
				.path("/pessoas/{id}")
				.buildAndExpand(pessoaBanco.getId())
				.toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> alterar(@PathVariable("id") @RequestBody @Validated Pessoa pessoa){
		this.pessoaService.update(pessoa);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
	}
	
	@DeleteMapping("{id}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		this.pessoaService.deletePessoaById(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("{id}/usuarios")
	@ResponseBody
	public ResponseEntity<Set<Usuario>> buscarUsuariosPorPessoa(@PathVariable("id") Long id){
		Pessoa pessoa = this.pessoaService.findOne(id);
		return new ResponseEntity<Set<Usuario>>(this.usuarioService.findUsuarioByPessoa(pessoa),HttpStatus.OK);
	}

}
