package com.vitormarcal.passbox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitormarcal.passbox.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {


}
