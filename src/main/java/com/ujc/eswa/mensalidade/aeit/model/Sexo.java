package com.ujc.eswa.mensalidade.aeit.model;

public enum Sexo {
	M("M", "Masculino"),
	F("F", "Feminino");
	private String sigla;
	private String descricao;
	private Sexo(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}
	
}
