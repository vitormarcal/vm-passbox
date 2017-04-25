package com.vitormarcal.passbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.vitormarcal.passbox.exception.ResourceNotFoundException;
import com.vitormarcal.passbox.model.Pessoa;
import com.vitormarcal.passbox.repository.Pessoas;

@Service
@Transactional
public class PessoaService {

	@Autowired
	private Pessoas pessoas;
	
	
	public Pessoa save(Pessoa pessoa) {
		Pessoa pessoaSalva = pessoas.save(pessoa);
		
		return pessoaSalva;
	}


	public List<Pessoa> findAll() {
		return pessoas.findAll();
	}
	
	public Pessoa findOne(Long id){
		
		Assert.notNull(id, "id da pessoa não pode ser nulo");
		Pessoa pessoa = pessoas.findOne(id);
		
		if(pessoa == null){
			throw new ResourceNotFoundException(id);
		}
		
		return pessoa;
	}
	
	public Pessoa update(Pessoa pessoa){
		Assert.notNull(pessoa.getId(), "id da pessoa não pode estar nulo");
		
		Pessoa pessoaBanco = pessoas.findOne(pessoa.getId()); 
		
		if(pessoaBanco == null){
			throw new ResourceNotFoundException(pessoa.getId());
		}
		
		Pessoa pessoaSalva = pessoas.save(pessoa);
		
		return pessoaSalva;
		
		
	}


	public void deletePessoaById(Long id) {
		Assert.notNull(id, "id da pessoa não pode ser nula");
		Pessoa pessoa = pessoas.findOne(id);
		
		if(pessoa == null){
			throw new ResourceNotFoundException(id);
		}
		
		pessoas.delete(id);
		
		
	}


}
