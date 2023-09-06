package com.persistencesoft.persistence.enumerator;

public enum TipoSubNichoEnum {
	
	AREA_ATUACAO(1), GANHAR_DINHEIRO(2), HOBBIES(3);
	
	private final int valor;
	
	TipoSubNichoEnum(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}

}
