package com.ujc.eswa.mensalidade.aeit.model;

import javax.persistence.*;

@Entity
@Table(name="Disciplina")
public class Disciplina {
	@Column(name="id_disciplina")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_disciplina;
	@Column(name="disc_nome")
	private String disc_nome;
	@Column(name="disc_credito")
	private int disc_credito;
	@Column(name="estatuto")
	private String estatuto;
	//@ManyToMany(mappedBy="Professor")
//	private Professor professor;
	public int getId_disciplina() {
		return id_disciplina;
	}
	public void setId_disciplina(int id_disciplina) {
		this.id_disciplina = id_disciplina;
	}
	public String getDisc_nome() {
		return disc_nome;
	}
	public void setDisc_nome(String disc_nome) {
		this.disc_nome = disc_nome;
	}
	public int getDisc_credito() {
		return disc_credito;
	}
	public void setDisc_credito(int disc_credito) {
		this.disc_credito = disc_credito;
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
