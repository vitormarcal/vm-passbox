package com.vitormarcal.passbox.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitormarcal.passbox.model.Pessoa;
import com.vitormarcal.passbox.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {

	Set<Usuario> findUsuarioByPessoa(Pessoa pessoa);

}

