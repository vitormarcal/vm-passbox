package com.vitormarcal.passbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.vitormarcal.passbox.exception.ResourceNotFoundException;
import com.vitormarcal.passbox.model.Usuario;
import com.vitormarcal.passbox.repository.Usuarios;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private Usuarios usuarios;
	
	
	public Usuario save(Usuario usuario) {
		Usuario usuarioSalva = this.usuarios.save(usuario);
		
		return usuarioSalva;
	}


	public List<Usuario> findAll() {
		return this.usuarios.findAll();
	}
	
	public Usuario findOne(Long id){
		
		Assert.notNull(id, "id do usuario não pode ser nulo");
		Usuario usuario = this.usuarios.findOne(id);
		
		if(usuario == null){
			throw new ResourceNotFoundException(id);
		}
		
		return usuario;
	}
	
	public Usuario update(Usuario usuario){
		Assert.notNull(usuario.getId(), "id do usuario não pode estar nulo");
		
		Usuario usuarioBanco = this.usuarios.findOne(usuario.getId()); 
		
		if(usuarioBanco == null){
			throw new ResourceNotFoundException(usuario.getId());
		}
		
		Usuario usuarioSalva = this.usuarios.save(usuario);
		
		return usuarioSalva;
		
		
	}


	public void deleteUsuarioById(Long id) {
		Assert.notNull(id, "id do usuario não pode ser nula");
		Usuario usuario = this.usuarios.findOne(id);
		
		if(usuario == null){
			throw new ResourceNotFoundException(id);
		}
		
		this.usuarios.delete(id);
		
		
	}



}