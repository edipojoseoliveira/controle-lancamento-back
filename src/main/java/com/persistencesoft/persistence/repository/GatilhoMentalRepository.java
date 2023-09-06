package com.persistencesoft.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistencesoft.persistence.model.GatilhoMental;

public interface GatilhoMentalRepository extends JpaRepository<GatilhoMental, Long> {
	
	public List<GatilhoMental> findAllByNomeContainsIgnoreCase(String nome);

}
