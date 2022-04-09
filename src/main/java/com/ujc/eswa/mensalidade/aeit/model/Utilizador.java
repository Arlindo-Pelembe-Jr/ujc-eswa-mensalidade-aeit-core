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
public  class Utilizador extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6622715455819268170L;
	@Column(name="nome", nullable=false)
	private String nome;
	@Column(name="apelido", nullable=false)
	private String apelido;
	@Column(name="data_nascimento", nullable=false)
	private Date dataNascimento;
	@Column(name="contacto", nullable=false)
	private double contacto;
	@Column(name="sexo", nullable=false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@Column(name="nacionalidade", nullable=false)
	private String nacionalidade;
	
	private String senha;
	
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
		return dataNascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.dataNascimento = data_nascimento;
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
	public Utilizador () {
		
	}
	public Utilizador(Long id, String nome, String apelido, Date data_nascimento, double contacto, Sexo sexo,
			String nacionalidade) {
		super();
		this.nome = nome;
		this.apelido = apelido;
		this.dataNascimento = data_nascimento;
		this.contacto = contacto;
		this.sexo = sexo;
		this.nacionalidade = nacionalidade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(apelido, contacto, dataNascimento, nacionalidade, nome, senha, sexo);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilizador other = (Utilizador) obj;
		return Objects.equals(apelido, other.apelido)
				&& Double.doubleToLongBits(contacto) == Double.doubleToLongBits(other.contacto)
				&& Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(nacionalidade, other.nacionalidade) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha) && sexo == other.sexo;
	}
	@Override
	public String toString() {
		return "Utilizador [nome=" + nome + ", apelido=" + apelido + ", dataNascimento=" + dataNascimento
				+ ", contacto=" + contacto + ", sexo=" + sexo + ", nacionalidade=" + nacionalidade + ", senha=" + senha
				+ "]";
	}


	

}
