package com.vitormarcal.passbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitormarcal.passbox.model.LocalCredenciado;

public interface Locais extends JpaRepository<LocalCredenciado, Long>{

}
