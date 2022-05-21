package com.ujc.eswa.mensalidade.aeit.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Estudante extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8519710901493485449L;
	

	@Column(name="data_ingresso")
	private Date dataIgresso;
	
	private Long codEstudante;
	private String nome;
	@Column(name="email")
	private String email;
	@Column(name="data_nascimento")
	private Date data_nascimento;
	@Column(name="contacto")
	private Long contacto;
	@Column(name="nacionalidade")
	private String nacionalidade;
//	@JsonIgnore
	@ManyToOne
	private Curso curso ;
	
	@ManyToOne
	private Utilizador utilizador;
	
	@ManyToMany
	private List<Mensalidade> mensalidades;

	
	public Utilizador getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Mensalidade> getMensalidades() {
		return mensalidades;
	}

	public void setMensalidades(List<Mensalidade> mensalidades) {
		this.mensalidades = mensalidades;
	}

	@ManyToMany
	@JoinTable(name="inscricao", joinColumns=@JoinColumn(name="estudante_id"), inverseJoinColumns=@JoinColumn(name="disciplina_id"))
	private List <Disciplina> disciplinas;
	
	@ManyToMany
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

	@Override
	public String toString() {
		return "Estudante [dataIgresso=" + dataIgresso + ", codEstudante=" + codEstudante + ", nome=" + nome
				+ ", curso=" + curso + ", disciplina=" + disciplinas + ", renovacao=" + "]";
	}


	
	
}
