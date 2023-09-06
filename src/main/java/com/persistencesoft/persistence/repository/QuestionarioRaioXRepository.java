package com.persistencesoft.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistencesoft.persistence.model.QuestionarioRaioX;

public interface QuestionarioRaioXRepository extends JpaRepository<QuestionarioRaioX, Long> {

	public List<QuestionarioRaioX> findAllByPerguntaContainsIgnoreCase(String pergunta);
	
}
