package com.ujc.eswa.mensalidade.aeit.model;

import java.sql.Date;

import javax.persistence.*;
@Entity
@Table(name="funcionario")
public class Funcionario extends BaseEntity {
	private static final long serialVersionUID = 5314332179792881532L;
	@ManyToOne
	@JoinColumn(name="cargo_id_fk")
	private Cargo Cargo;
	
	private Long codEstudante;
	private String nome;
	private String email;
	private String dataNascimento;
	private Long contacto;
	private String nacionalidade;
	
	@ManyToOne
	private Utilizador utilizador;
	
	
	public Long getCodEstudante() {
		return codEstudante;
	}


	public void setCodEstudante(Long codEstudante) {
		this.codEstudante = codEstudante;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Long getContacto() {
		return contacto;
	}


	public void setContacto(Long contacto) {
		this.contacto = contacto;
	}


	public String getNacionalidade() {
		return nacionalidade;
	}


	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}


	public Utilizador getUtilizador() {
		return utilizador;
	}


	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Funcionario() {
		super();
	}


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
