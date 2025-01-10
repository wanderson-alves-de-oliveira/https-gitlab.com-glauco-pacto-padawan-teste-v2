package com.padwan.test.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.padwan.test.enums.Status;

@Entity(name="jedi")
@Table(name="jedi")
public class Jedi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "status")
	@Enumerated(value = EnumType.STRING)
	private Status status;
	
	@Column(name = "mentor")
	private String mentor;
	
	@Column(name = "midichlorians", precision = 19, scale = 3)
	private BigDecimal midichlorians;

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
