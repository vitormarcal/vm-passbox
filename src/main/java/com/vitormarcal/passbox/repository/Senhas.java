package com.vitormarcal.passbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitormarcal.passbox.model.Senha;

public interface Senhas extends JpaRepository<Senha, Long>{

}
