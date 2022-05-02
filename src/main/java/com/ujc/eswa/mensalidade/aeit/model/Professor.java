package com.ujc.eswa.mensalidade.aeit.model;

import javax.persistence.*;

@Entity
@Table(name="professor")
public class Professor extends BaseEntity{


	@Column(name="tipo_professor")
	private String profTipo;
	@Column(name="nivel_academico")
	private String nivelAcademico;
	@ManyToOne
	@JoinColumn(name="id_cargo_fk")
	private Cargo Cargo;
	public String getProfTipo() {
		return profTipo;
	}
	public void setProfTipo(String profTipo) {
		this.profTipo = profTipo;
	}
	public String getNivelAcademico() {
		return nivelAcademico;
	}
	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}
	public Cargo getCargo() {
		return Cargo;
	}
	public void setCargo(Cargo cargo) {
		this.Cargo = cargo;
	}
	
}
