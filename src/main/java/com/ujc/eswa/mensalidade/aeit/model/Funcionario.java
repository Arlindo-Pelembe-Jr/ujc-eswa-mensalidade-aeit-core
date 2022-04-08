package com.ujc.eswa.mensalidade.aeit.model;

import java.sql.Date;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Table(name="funcionario")
public class Funcionario extends BaseEntity {
	private static final long serialVersionUID = 5314332179792881532L;
	@Column(name="data_ingresso_funcionario")
	private Date data_ingresso_funcionario;

	public Date getData_ingresso() {
		return data_ingresso_funcionario;
	}

	public void setData_ingresso(Date data_ingresso) {
		this.data_ingresso_funcionario = data_ingresso;
	}

	public Funcionario(int id, String nome, String apelido, Date data_nascimento, double contacto, Sexo sexo,
			String nacionalidade, Date data_ingresso) {
		this.data_ingresso_funcionario = data_ingresso;
	}
	
	


	
}
