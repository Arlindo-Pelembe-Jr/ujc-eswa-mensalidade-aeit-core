package com.ujc.eswa.mensalidade.aeit.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Disciplina")
public class Disciplina {
	@Column(name="id_disciplina")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDisciplina;
	@Column(name="disc_nome")
	private String discNome;
	@Column(name="disc_credito")
	private int discCredito;
	@Column(name="estatuto")
	private String estatuto;
	@OneToOne
	@JoinTable(name="inscricao")
	private Estudante estudante;
	
	
	
	public Disciplina() {
		super();
	}
	public Estudante getEstudante() {
		return estudante;
	}
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	@OneToOne
	@JoinTable(name="disciplina_curso")
	private Curso curso;
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Long getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	public String getDiscNome() {
		return discNome;
	}
	public void setDiscNome(String discNome) {
		this.discNome = discNome;
	}
	public int getDiscCredito() {
		return discCredito;
	}
	public void setDiscCredito(int discCredito) {
		this.discCredito = discCredito;
	}
	
	
	
	//@ManyToMany(mappedBy="Professor")
//	private Professor professor;
	public Long getId_disciplina() {
		return idDisciplina;
	}
	public void setId_disciplina(Long id_disciplina) {
		this.idDisciplina = id_disciplina;
	}
	public String getDisc_nome() {
		return discNome;
	}
	public void setDisc_nome(String disc_nome) {
		this.discNome = disc_nome;
	}
	public int getDisc_credito() {
		return discCredito;
	}
	public void setDisc_credito(int disc_credito) {
		this.discCredito = disc_credito;
	}
	public String getEstatuto() {
		return estatuto;
	}
	public void setEstatuto(String estatuto) {
		this.estatuto = estatuto;
	}
	/*public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
*/
	
}
