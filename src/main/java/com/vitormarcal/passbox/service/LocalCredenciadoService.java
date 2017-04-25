package com.vitormarcal.passbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.vitormarcal.passbox.exception.ResourceNotFoundException;
import com.vitormarcal.passbox.model.LocalCredenciado;
import com.vitormarcal.passbox.repository.Locais;

@Service
@Transactional
public class LocalCredenciadoService {

	@Autowired
	private Locais locais;
	
	
	public LocalCredenciado save(LocalCredenciado localCredenciado) {
		LocalCredenciado localCredenciadoSalva = locais.save(localCredenciado);
		
		return localCredenciadoSalva;
	}


	public List<LocalCredenciado> findAll() {
		return locais.findAll();
	}
	
	public LocalCredenciado findOne(Long id){
		
		Assert.notNull(id, "id da localCredenciado não pode ser nulo");
		LocalCredenciado localCredenciado = locais.findOne(id);
		
		if(localCredenciado == null){
			throw new ResourceNotFoundException(id);
		}
		
		return localCredenciado;
	}
	
	public LocalCredenciado update(LocalCredenciado localCredenciado){
		Assert.notNull(localCredenciado.getId(), "id da localCredenciado não pode estar nulo");
		
		LocalCredenciado localCredenciadoBanco = locais.findOne(localCredenciado.getId()); 
		
		if(localCredenciadoBanco == null){
			throw new ResourceNotFoundException(localCredenciado.getId());
		}
		
		LocalCredenciado localCredenciadoSalva = locais.save(localCredenciado);
		
		return localCredenciadoSalva;
		
		
	}


	public void deleteLocalCredenciadoById(Long id) {
		Assert.notNull(id, "id da localCredenciado não pode ser nula");
		LocalCredenciado localCredenciado = locais.findOne(id);
		
		if(localCredenciado == null){
			throw new ResourceNotFoundException(id);
		}
		
		locais.delete(id);
		
		
	}


}
