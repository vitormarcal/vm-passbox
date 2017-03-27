package com.vitormarcal.passbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitormarcal.passbox.model.Pessoa;

public interface Pessoas extends JpaRepository<Pessoa, Long>{

}
