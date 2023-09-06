package com.persistencesoft.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "questionarioraiox")
public class QuestionarioRaioX {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String pergunta;
	private String resposta;
	
	public QuestionarioRaioX() {
		super();
	}
	
	public QuestionarioRaioX(Long id, String pergunta, String resposta) {
		super();
		this.id = id;
		this.pergunta = pergunta;
		this.resposta = resposta;
	}

	@Override
	public String toString() {
		return String.format("QuestionarioRaioX [id=%s, pergunta=%s, resposta=%s]", id, pergunta, resposta);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

}
