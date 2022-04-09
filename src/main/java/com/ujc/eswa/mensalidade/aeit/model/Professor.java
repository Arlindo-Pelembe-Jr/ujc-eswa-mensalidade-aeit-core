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
	private Cargo cargo;
	
}
