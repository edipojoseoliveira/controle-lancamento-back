package com.persistencesoft.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistencesoft.persistence.model.Metodo;

public interface MetodoRepository extends JpaRepository<Metodo, Long> {
	
	public List<Metodo> findAllByNomeContainsIgnoreCase(String nome);

}
