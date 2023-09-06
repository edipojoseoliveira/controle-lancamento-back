package com.persistencesoft.persistence.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 653494008825383776L;

	public ObjectNotFoundException(Long id) {
		super("Não foi possível encontrar o registro com id " + id);
	}
	
}
