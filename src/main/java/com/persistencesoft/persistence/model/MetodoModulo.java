package com.persistencesoft.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "metodomodulo")
public class MetodoModulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String descricao;
	@Column(name = "idmetodo")
	private Integer idMetodo;
	@Column(name = "idmetodomodulopai")
	private Integer idMetodoModuloPai;
	
	public MetodoModulo() {
		super();
	}

	public MetodoModulo(Long id, String nome, String descricao, Integer idMetodo, Integer idMetodoModuloPai) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.idMetodo = idMetodo;
		this.idMetodoModuloPai = idMetodoModuloPai;
	}

	@Override
	public String toString() {
		return String.format("MetodoModulo [id=%s, nome=%s, descricao=%s, idMetodo=%s, idMetodoModuloPai=%s]", id, nome,
				descricao, idMetodo, idMetodoModuloPai);
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getIdMetodo() {
		return idMetodo;
	}

	public void setIdMetodo(Integer idMetodo) {
		this.idMetodo = idMetodo;
	}

	public Integer getIdMetodoModuloPai() {
		return idMetodoModuloPai;
	}

	public void setIdMetodoModuloPai(Integer idMetodoModuloPai) {
		this.idMetodoModuloPai = idMetodoModuloPai;
	}
	
}
