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
	

	private String dataIgresso;
	
	private Long codEstudante;
	private String nome;
	private String email;
	private String dataNascimento;
	private Long contacto;
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

	public String getDataIgresso() {
		return dataIgresso;
	}

	public void setDataIgresso(String dataIgresso) {
		this.dataIgresso = dataIgresso;
	}

	public Long getCodEstudante() {
		return codEstudante;
	}

	public void setCodEstudante(Long codEstudante) {
		this.codEstudante = codEstudante;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getData_nascimento() {
		return dataNascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.dataNascimento = data_nascimento;
	}

	public Long getContacto() {
		return contacto;
	}

	public void setContacto(Long contacto) {
		this.contacto = contacto;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Estudante() {
		super();
	}

	public Estudante(Long id, String nome, String apelido, String data_nascimento, double contacto, Sexo sexo,
			String nacionalidade, String data_ingresso, Long cod_estudante, Curso curso) {
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

	public String getData_ingresso() {
		return dataIgresso;
	}


	public void setData_ingresso(String data_ingresso) {
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
