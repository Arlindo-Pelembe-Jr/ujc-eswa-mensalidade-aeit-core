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
	private String nomeCurso;
	@Column(name="curso_codigo")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cursoCodigo;
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public String getNome_curso() {
		return nomeCurso;
	}
	public void setNome_curso(String nome_curso) {
		this.nomeCurso = nome_curso;
	}
	public Long getCurso_codigo() {
		return cursoCodigo;
	}
	public void setCurso_codigo(Long cursoCodigo) {
		this.cursoCodigo = cursoCodigo;
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
	public Curso(  String nome_curso, Long curso_codigo) {
	
		this.departamento = departamento;
		this.nomeCurso = nome_curso;
		this.cursoCodigo = cursoCodigo;
		//this.cursos = cursos;
	}
	
}
