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
	@ManyToOne
	@JoinColumn(name="cargo_id_fk")
	private Cargo Cargo;


	public Cargo getCargo() {
		return Cargo;
	}

	public void setCargo(Cargo cargo) {
		this.Cargo = cargo;
	}

	public Date getDataIngressoFuncionario() {
		return dataIngressoFuncionario;
	}

	public void setDataIngressoFuncionario(Date dataIngressoFuncionario) {
		this.dataIngressoFuncionario = dataIngressoFuncionario;
	}

	@Column(name="data_ingresso_funcionario")
	private Date dataIngressoFuncionario;

	public Date getData_ingresso() {
		return dataIngressoFuncionario;
	}

	public void setData_ingresso(Date data_ingresso) {
		this.dataIngressoFuncionario = data_ingresso;
	}

	public Funcionario(int id, String nome, String apelido, Date data_nascimento, double contacto, Sexo sexo,
			String nacionalidade, Date data_ingresso) {
		this.dataIngressoFuncionario = data_ingresso;
	}
	
	
	


	
}
