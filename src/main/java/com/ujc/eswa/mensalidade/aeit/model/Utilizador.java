package com.ujc.eswa.mensalidade.aeit.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@Entity
public  class Utilizador {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nome", nullable=false)
	private String nome;
	@Column(name="apelido", nullable=false)
	private String apelido;
	@Column(name="data_nascimento", nullable=false)
	private Date data_nascimento;
	@Column(name="contacto", nullable=false)
	private double contacto;
	@Column(name="sexo", nullable=false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@Column(name="nacionalidade", nullable=false)
	private String nacionalidade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public double getContacto() {
		return contacto;
	}
	public void setContacto(double contacto) {
		this.contacto = contacto;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public Utilizador(int id, String nome, String apelido, Date data_nascimento, double contacto, Sexo sexo,
			String nacionalidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.apelido = apelido;
		this.data_nascimento = data_nascimento;
		this.contacto = contacto;
		this.sexo = sexo;
		this.nacionalidade = nacionalidade;
	}
	@Override
	public String toString() {
		return "Utilizador [id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", data_nascimento="
				+ data_nascimento + ", contacto=" + contacto + ", sexo=" + sexo + ", nacionalidade=" + nacionalidade
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(apelido, contacto, data_nascimento, id, nacionalidade, nome, sexo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilizador other = (Utilizador) obj;
		return Objects.equals(apelido, other.apelido)
				&& Double.doubleToLongBits(contacto) == Double.doubleToLongBits(other.contacto)
				&& Objects.equals(data_nascimento, other.data_nascimento) && id == other.id
				&& Objects.equals(nacionalidade, other.nacionalidade) && Objects.equals(nome, other.nome)
				&& sexo == other.sexo;
	}
	

}
