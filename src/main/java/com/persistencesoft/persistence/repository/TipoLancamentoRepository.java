package com.persistencesoft.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistencesoft.persistence.model.TipoLancamento;

public interface TipoLancamentoRepository extends JpaRepository<TipoLancamento, Long> {
	
	public List<TipoLancamento> findAllByNomeContainsIgnoreCase(String nome);

}
