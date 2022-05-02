package com.ujc.eswa.mensalidade.aeit.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Curso")
public class Curso {
	
	@ManyToMany
	@JoinTable(name="renovacao_estudante", joinColumns=@JoinColumn(name="curso_id"), inverseJoinColumns=@JoinColumn(name="estudante"))
	private List<Estudante>estudantes2;
	

	
	public List<Estudante> getEstudantes2() {
		return estudantes2;
	}
	public void setEstudantes2(List<Estudante> estudantes2) {
		this.estudantes2 = estudantes2;
	}
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Long getCursoCodigo() {
		return cursoCodigo;
	}

	public void setCursoCodigo(Long cursoCodigo) {
		this.cursoCodigo = cursoCodigo;
	}
	
	@ManyToMany(mappedBy="cursos")
	private List <Departamento> departamentos;
	
	@ManyToMany(mappedBy="cursos")
	private List<Disciplina> disciplinas;
	@Column(name = "nome_curso")
	private String nomeCurso;
	@Column(name = "curso_codigo")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cursoCodigo;

	public Curso() {
		super();
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
	private List<Estudante> estudantes = new ArrayList<>();
//	public String getNome_departamento() {   isto e um metodo recursivo chame a se mesmo e cria problema na pesquisa
//		return getNome_departamento();
//	}
	public List<Estudante> getEstudantes() {
		return estudantes;
	}
	public void setEstudantes(List<Estudante> estudantes) {
		this.estudantes = estudantes;
	}
	public Curso(  String nome_curso, Long curso_codigo) {
	
	
		this.nomeCurso = nome_curso;
		this.cursoCodigo = cursoCodigo;
		// this.cursos = cursos;
	}

	public Curso(String nomeCurso) {
		super();
		this.nomeCurso = nomeCurso;
	}

	public Curso(Long cursoCodigo) {
		super();
		this.cursoCodigo = cursoCodigo;
	}
	
}
