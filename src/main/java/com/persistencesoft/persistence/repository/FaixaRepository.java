package com.persistencesoft.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistencesoft.persistence.model.Faixa;

public interface FaixaRepository extends JpaRepository<Faixa, Long> {
	
	public List<Faixa> findAllByNomeContainsIgnoreCase(String nome);

}
