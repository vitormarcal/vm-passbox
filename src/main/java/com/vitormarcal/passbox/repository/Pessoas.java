package com.vitormarcal.passbox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitormarcal.passbox.model.Pessoa;
import com.vitormarcal.passbox.model.Usuario;

public interface Pessoas extends JpaRepository<Pessoa, Long>{

	List<Usuario> findUsuarioById(Long id);

}
