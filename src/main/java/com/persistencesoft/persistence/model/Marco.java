package com.persistencesoft.persistence.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "marco")
public class Marco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer posicao;
	private String nome;
	private String meta;
	private boolean concluido;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idjornada", nullable = false)
	private Jornada jornada;
	
	public Marco() {
	}

	public Marco(Long id, Integer posicao, String nome, String meta, boolean concluido) {
		super();
		this.id = id;
		this.posicao = posicao;
		this.nome = nome;
		this.meta = meta;
		this.concluido = concluido;
	}

	@Override
	public String toString() {
		return String.format("Marco [id=%s, posicao=%s, nome=%s, meta=%s, concluido=%s]", id, posicao, nome, meta,
				concluido);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPosicao() {
		return posicao;
	}
	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
	public boolean isConcluido() {
		return concluido;
	}
	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
	public Jornada getJornada() {
		return jornada;
	}
	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

}
