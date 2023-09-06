package com.persistencesoft.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistencesoft.persistence.model.MetodoModulo;

public interface MetodoModuloRepository extends JpaRepository<MetodoModulo, Long> {
	
	public List<MetodoModulo> findAllByIdMetodoAndIdMetodoModuloPai(Integer idMetodo, Integer idMetodoModuloPai);

}
