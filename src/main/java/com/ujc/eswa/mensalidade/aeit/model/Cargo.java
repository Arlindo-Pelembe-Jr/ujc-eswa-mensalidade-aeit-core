package com.ujc.eswa.mensalidade.aeit.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="cargo")
public class Cargo {
	
	@OneToMany
	private List<Funcionario> funcionarios;
	
	@OneToMany
	private List<Professor> professores;
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public long getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(long idCargo) {
		this.idCargo = idCargo;
	}
	public String getNomeCargo() {
		return nomeCargo;
	}
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
	@Id
	@Column(name="id_cargo")
	private long idCargo;
	@Column(name="nome_cargo")
	 private String nomeCargo;
}
