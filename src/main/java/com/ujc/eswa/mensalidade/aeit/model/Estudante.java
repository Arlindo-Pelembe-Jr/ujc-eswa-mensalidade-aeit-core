package com.ujc.eswa.mensalidade.aeit.model;

import java.sql.Date;

import javax.persistence.*;
@Entity
@Table(name="Estudante")
public class Estudante extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8519710901493485449L;
	@Column(name="data_ingresso")
	private Date data_ingresso;
	@Column(name="cod_estudante")
	@Id
	private int cod_estudante;
	@ManyToOne
	@JoinColumn(name="curso_id_fk")
	private Curso curso ;

	public Estudante(int id, String nome, String apelido, Date data_nascimento, double contacto, Sexo sexo,
			String nacionalidade, Date data_ingresso, int cod_estudante, Curso curso) {
		this.data_ingresso = data_ingresso;
		this.cod_estudante = cod_estudante;
		this.curso = curso;
	}

	public int getCod_estudante() {
		return cod_estudante;
	}

	public void setCod_estudante(int cod_estudante) {
		this.cod_estudante = cod_estudante;
	}

	public Date getData_ingresso() {
		return data_ingresso;
	}


	public void setData_ingresso(Date data_ingresso) {
		this.data_ingresso = data_ingresso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
