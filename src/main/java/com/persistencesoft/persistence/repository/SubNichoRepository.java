package com.persistencesoft.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistencesoft.persistence.model.SubNicho;

public interface SubNichoRepository extends JpaRepository<SubNicho, Long> {
	
	public List<SubNicho> findAllByNomeContainsIgnoreCase(String nome);

}
