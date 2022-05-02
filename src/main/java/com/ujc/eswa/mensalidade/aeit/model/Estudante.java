package com.ujc.eswa.mensalidade.aeit.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="estudante")
public class Estudante extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8519710901493485449L;
	@Column(name="data_ingresso")
	private Date dataIgresso;
	
	private Long codEstudante;
	private String nome;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="curso_id_fk")
	private Curso curso ;
	
	@ManyToMany(mappedBy="estudantes")
	private List<Mensalidade> mensalidades;
	

	public List<Mensalidade> getMensalidades() {
		return mensalidades;
	}

	public void setMensalidades(List<Mensalidade> mensalidades) {
		this.mensalidades = mensalidades;
	}

	@ManyToMany
	@JoinTable(name="inscricao", joinColumns=@JoinColumn(name="estudante_id"), inverseJoinColumns=@JoinColumn(name="disciplina_id"))
	private List <Disciplina> disciplinas;
	
	@ManyToMany(mappedBy="estudantes2")
	private List <Curso> cursos;



	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Date getDataIgresso() {
		return dataIgresso;
	}

	public void setDataIgresso(Date dataIgresso) {
		this.dataIgresso = dataIgresso;
	}

	public Long getCodEstudante() {
		return codEstudante;
	}

	public void setCodEstudante(Long codEstudante) {
		this.codEstudante = codEstudante;
	}



	public Estudante() {
		super();
	}

	public Estudante(Long id, String nome, String apelido, Date data_nascimento, double contacto, Sexo sexo,
			String nacionalidade, Date data_ingresso, Long cod_estudante, Curso curso) {
		this.dataIgresso = data_ingresso;
		this.codEstudante = cod_estudante;
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCod_estudante() {
		return codEstudante;
	}

	public void setCod_estudante(Long cod_estudante) {
		this.codEstudante = cod_estudante;
	}

	public Date getData_ingresso() {
		return dataIgresso;
	}


	public void setData_ingresso(Date data_ingresso) {
		this.dataIgresso = data_ingresso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
