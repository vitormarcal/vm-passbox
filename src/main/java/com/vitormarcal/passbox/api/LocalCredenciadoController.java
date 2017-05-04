package com.vitormarcal.passbox.api;

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

import com.vitormarcal.passbox.model.LocalCredenciado;
import com.vitormarcal.passbox.service.LocalCredenciadoService;

@RestController
@RequestMapping("/localCredenciados")
public class LocalCredenciadoController {

	
	
	@Autowired
	private LocalCredenciadoService localCredenciadoService;
	

	
	@GetMapping
	public ResponseEntity<List<LocalCredenciado>> listar(){
		return new ResponseEntity<List<LocalCredenciado>>(this.localCredenciadoService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<LocalCredenciado> buscar(@PathVariable("id") Long id){
		LocalCredenciado localCredenciado = this.localCredenciadoService.findOne(id);
		return new ResponseEntity<>(localCredenciado, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Validated LocalCredenciado localCredenciado){
		LocalCredenciado localCredenciadoBanco = this.localCredenciadoService.save(localCredenciado);
		
		URI location = ServletUriComponentsBuilder.
				fromContextPath(null)
				.path("/localCredenciados/{id}")
				.buildAndExpand(localCredenciadoBanco.getId())
				.toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> alterar(@PathVariable("id") @RequestBody @Validated LocalCredenciado localCredenciado){
		this.localCredenciadoService.update(localCredenciado);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
	}
	
	@DeleteMapping("{id}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		this.localCredenciadoService.deleteLocalCredenciadoById(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
