package com.ujc.eswa.mensalidade.aeit.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Renovacao_estudante")
public class Renovacao {

	@Column(name="ano")
	private Long ano;
	@Column(name="semestre")
	private Long semestre;
	@Id
	private Long codRenovacao;
	
	public Long getAno() {
		return ano;
	}
	public void setAno(Long ano) {
		this.ano = ano;
	}
	public Long getSemestre() {
		return semestre;
	}
	public void setSemestre(Long semestre) {
		this.semestre = semestre;
	}
	public Long getCodRenovacao() {
		return codRenovacao;
	}
	public void setCodRenovacao(Long codRenovacao) {
		this.codRenovacao = codRenovacao;
	}
	
	
	
}
