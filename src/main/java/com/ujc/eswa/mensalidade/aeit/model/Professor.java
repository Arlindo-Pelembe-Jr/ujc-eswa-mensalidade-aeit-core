package com.ujc.eswa.mensalidade.aeit.model;

import javax.persistence.*;

@Entity
@Table(name="professor")
public class Professor extends BaseEntity{




	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7530573451565110721L;
@Column(name="nome_professor")
private String nome_professor; 

	@Column(name="nivel_academico")
	private String nivelAcademico;
	@ManyToOne
	@JoinColumn(name="id_cargo_fk")
	private Cargo Cargo;

	public String getNivelAcademico() {
		return nivelAcademico;
	}
	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}
	
	public void setCargo(Cargo cargo) {
		this.Cargo = cargo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Professor() {
		super();
	}
	

	
}
