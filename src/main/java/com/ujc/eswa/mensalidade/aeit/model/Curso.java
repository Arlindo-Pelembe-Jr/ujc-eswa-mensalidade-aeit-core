package com.ujc.eswa.mensalidade.aeit.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Curso")
public class Curso {
	

	

	@ManyToOne
	@JoinColumn(name="id_departamento")
	private Departamento departamento;
	
	@Column(name="nome_curso")
	private String nome_curso;
	@Column(name="curso_codigo")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int curso_codigo;
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public String getNome_curso() {
		return nome_curso;
	}
	public void setNome_curso(String nome_curso) {
		this.nome_curso = nome_curso;
	}
	public int getCurso_codigo() {
		return curso_codigo;
	}
	public void setCurso_codigo(int curso_codigo) {
		this.curso_codigo = curso_codigo;
	}
	@OneToMany(mappedBy="curso")
	private List<Estudante> estudantes;
	public String getNome_departamento() {
		return getNome_departamento();
	}
	public List<Estudante> getEstudantes() {
		return estudantes;
	}
	public void setEstudantes(List<Estudante> estudantes) {
		this.estudantes = estudantes;
	}
	public Curso(  String nome_curso, int curso_codigo) {
	
		this.departamento = departamento;
		this.nome_curso = nome_curso;
		this.curso_codigo = curso_codigo;
		//this.cursos = cursos;
	}
	
}
