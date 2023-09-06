package com.persistencesoft.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.persistencesoft.persistence.enumerator.TipoSubNichoEnum;

@Entity(name = "subnicho")
public class SubNicho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private TipoSubNichoEnum tipo;
	@Column(name = "resultadodoexpert")
	private boolean resultadoDoExpert;
	@Column(name = "resultadodeclientes")
	private boolean resultadoDeClientes;
	@Column(name = "pessoaspedindoproduto")
	private boolean pessoasPedindoProduto;
	private boolean ativo;
	
	public SubNicho() {
		super();
	}

	public SubNicho(Long id, String nome, TipoSubNichoEnum tipo, boolean resultadoDoExpert, boolean resultadoDeClientes,
			boolean pessoasPedindoProduto, boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.resultadoDoExpert = resultadoDoExpert;
		this.resultadoDeClientes = resultadoDeClientes;
		this.pessoasPedindoProduto = pessoasPedindoProduto;
		this.ativo = ativo;
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
	public TipoSubNichoEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoSubNichoEnum tipo) {
		this.tipo = tipo;
	}
	public boolean isResultadoDoExpert() {
		return resultadoDoExpert;
	}
	public void setResultadoDoExpert(boolean resultadoDoExpert) {
		this.resultadoDoExpert = resultadoDoExpert;
	}

	public boolean isResultadoDeClientes() {
		return resultadoDeClientes;
	}
	public void setResultadoDeClientes(boolean resultadoDeClientes) {
		this.resultadoDeClientes = resultadoDeClientes;
	}
	public boolean isPessoasPedindoProduto() {
		return pessoasPedindoProduto;
	}
	public void setPessoasPedindoProduto(boolean pessoasPedindoProduto) {
		this.pessoasPedindoProduto = pessoasPedindoProduto;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
