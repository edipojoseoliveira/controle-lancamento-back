package com.persistencesoft.persistence.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "jornada")
public class Jornada {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@JsonManagedReference
	@OneToMany(mappedBy = "jornada", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@OrderBy("posicao")
	private List<Marco> marcos;

	public Jornada() {
		super();
	}
	
	public Jornada(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return String.format("Jornada [id=%s, nome=%s]", id, nome);
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
	public List<Marco> getMarcos() {
		return marcos;
	}
	public void setMarcos(List<Marco> marcos) {
		this.marcos = marcos;
	}
	
}
