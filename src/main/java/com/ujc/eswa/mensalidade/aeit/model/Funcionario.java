package com.ujc.eswa.mensalidade.aeit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Funcionario {
	private String nome;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	public Funcionario(String nome, int codEstudante) {
		super();
		this.nome = nome;
		this.id = codEstudante;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodEstudante() {
		return id;
	}
	public void setCodEstudante(int codEstudante) {
		this.id = codEstudante;
	}
	
}
