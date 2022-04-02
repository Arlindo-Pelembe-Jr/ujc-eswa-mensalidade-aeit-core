package com.ujc.eswa.mensalidade.aeit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudante {
	private String nome;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codEstudante;
	
	public Estudante(String nome, int codEstudante) {
		super();
		this.nome = nome;
		this.codEstudante = codEstudante;
	}
	
	public Estudante() {
		super();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodEstudante() {
		return codEstudante;
	}
	public void setCodEstudante(int codEstudante) {
		this.codEstudante = codEstudante;
	}
	
}
