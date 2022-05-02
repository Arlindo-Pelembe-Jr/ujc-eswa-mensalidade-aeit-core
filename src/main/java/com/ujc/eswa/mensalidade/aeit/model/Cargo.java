package com.ujc.eswa.mensalidade.aeit.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="cargo")
public class Cargo {
	
	@OneToMany(mappedBy="Cargo")
	private List<Funcionario> funcionarios= new ArrayList<>();
	
	@OneToMany(mappedBy="Cargo")
	private List<Professor> professores= new ArrayList<>();
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionarios = funcionario;
	}
	public List<Professor> getProfessor() {
		return professores;
	}
	public void setProfessor(List<Professor> professor) {
		this.professores = professor;
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
