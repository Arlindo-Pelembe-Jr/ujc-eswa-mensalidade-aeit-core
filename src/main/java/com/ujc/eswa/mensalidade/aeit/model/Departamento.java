package com.ujc.eswa.mensalidade.aeit.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Departamento")
public class Departamento {
	@Column(name="nome_departamento")
	private String nome_departamento;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_departamento")
	private int cod_departamento;
	@OneToMany//(mappedBy="Curso")
	private List<Curso>cursos;
	public String getNome_departamento() {
		return nome_departamento;
	}
	public void setNome_departamento(String nome_departamento) {
		this.nome_departamento = nome_departamento;
	}
	public int getCod_departamento() {
		return cod_departamento;
	}
	public void setCod_departamento(int cod_departamento) {
		this.cod_departamento = cod_departamento;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}
