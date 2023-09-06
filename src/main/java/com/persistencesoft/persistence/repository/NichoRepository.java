package com.persistencesoft.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistencesoft.persistence.model.Nicho;

public interface NichoRepository extends JpaRepository<Nicho, Long> {
	
	public List<Nicho> findAllByNomeContainsIgnoreCase(String nome);

}
