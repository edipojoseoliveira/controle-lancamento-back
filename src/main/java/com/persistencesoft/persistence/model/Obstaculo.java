package com.persistencesoft.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "obstaculo")
public class Obstaculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@Column(name = "comosuperar")
	private String comoSuperar;
	
	public Obstaculo() {
		super();
	}

	public Obstaculo(Long id, String nome, String comoSuperar) {
		super();
		this.id = id;
		this.nome = nome;
		this.comoSuperar = comoSuperar;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getComoSuperar() {
		return comoSuperar;
	}
	public void setComoSuperar(String comoSuperar) {
		this.comoSuperar = comoSuperar;
	}

}
