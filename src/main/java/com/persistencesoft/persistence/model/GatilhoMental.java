package com.persistencesoft.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "gatilhomental")
public class GatilhoMental {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@Column(name = "beneficiodeaplicar")
	private String beneficioDeAplicar;
	@Column(name = "ondeaplicar")
	private String ondeAplicar;
	@Column(name = "comoaplicar")
	private String comoAplicar;
	@Column(name = "visaogeral")
	private String visaoGeral;
	private String observacao;

	public GatilhoMental() {
	}

	public GatilhoMental(String nome, String beneficioDeAplicar, String ondeAplicar, String comoAplicar,
			String visaoGeral, String observacao) {
		this.nome = nome;
		this.beneficioDeAplicar = beneficioDeAplicar;
		this.ondeAplicar = ondeAplicar;
		this.comoAplicar = comoAplicar;
		this.visaoGeral = visaoGeral;
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return String.format(
				"GatilhoMental [id=%s, nome=%s, beneficioDeAplicar=%s, ondeAplicar=%s, comoAplicar=%s, visaoGeral=%s, observacao=%s]",
				id, nome, beneficioDeAplicar, ondeAplicar, comoAplicar, visaoGeral, observacao);
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

	public String getBeneficioDeAplicar() {
		return beneficioDeAplicar;
	}

	public void setBeneficioDeAplicar(String beneficioDeAplicar) {
		this.beneficioDeAplicar = beneficioDeAplicar;
	}

	public String getOndeAplicar() {
		return ondeAplicar;
	}

	public void setOndeAplicar(String ondeAplicar) {
		this.ondeAplicar = ondeAplicar;
	}

	public String getComoAplicar() {
		return comoAplicar;
	}

	public void setComoAplicar(String comoAplicar) {
		this.comoAplicar = comoAplicar;
	}

	public String getVisaoGeral() {
		return visaoGeral;
	}

	public void setVisaoGeral(String visaoGeral) {
		this.visaoGeral = visaoGeral;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
