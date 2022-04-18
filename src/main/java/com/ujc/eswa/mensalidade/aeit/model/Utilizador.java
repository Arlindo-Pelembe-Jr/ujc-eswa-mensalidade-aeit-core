package com.ujc.eswa.mensalidade.aeit.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
@Entity
public  class Utilizador extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6622715455819268170L;
	@Column(name="nome")
	private String nome;
	

	@Column
	private String senha;
	@Column
	private String userName;
	@Column
	private String email;
	
	@OneToMany(mappedBy = "utilizador", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<PerfilUtilizador> perfiSet =new HashSet<>();
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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

	public Utilizador () {
		
	}
	public Utilizador(Long id, String nome) {
		super();
		this.nome = nome;
	
	}



	

}
