package com.padwan.test.dto;

import java.math.BigDecimal;

import com.padwan.test.enums.Status;

public class JediDTO {

	private String nome;

	private Status status;

	private String mentor;

	private BigDecimal midichlorians;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMentor() {
		return mentor;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
	}

	public BigDecimal getMidichlorians() {
		return midichlorians;
	}

	public void setMidichlorians(BigDecimal midichlorians) {
		this.midichlorians = midichlorians;
	}

}
