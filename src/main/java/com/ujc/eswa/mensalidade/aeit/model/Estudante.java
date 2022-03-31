package com.ujc.eswa.mensalidade.aeit.model;

public class Estudante {
	private String nome;
	private int codEstudante;
	
	public Estudante(String nome, int codEstudante) {
		super();
		this.nome = nome;
		this.codEstudante = codEstudante;
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
