package com.ujc.eswa.mensalidade.aeit.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Departamento")
public class Departamento {
	@Column(name="nome_departamento")
	private String nomeDepartamento;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_departamento")
	private Long codDepartamento;
	@ManyToMany
	@JoinTable(name="departamento_curso", joinColumns=@JoinColumn(name="departamento_id"), inverseJoinColumns=@JoinColumn(name="curso_id"))
	private List <Curso> cursos;
	public String getNome_departamento() {
		return nomeDepartamento;
	}
	public void setNome_departamento(String nome_departamento) {
		this.nomeDepartamento = nome_departamento;
	}
	public Long getCod_departamento() {
		return codDepartamento;
	}
	public void setCod_departamento(Long cod_departamento) {
		this.codDepartamento = cod_departamento;
	}

	
}
