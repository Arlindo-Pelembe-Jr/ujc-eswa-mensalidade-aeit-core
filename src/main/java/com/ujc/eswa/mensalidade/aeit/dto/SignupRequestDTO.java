package com.ujc.eswa.mensalidade.aeit.dto;

import java.io.Serializable;

import com.ujc.eswa.mensalidade.aeit.model.PerfilUtilizador;

public class SignupRequestDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5721872758582459104L;

	private String email;
	private String senha;
	private String nome;
	private PerfilUtilizador perfilUtilizador;
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public PerfilUtilizador getPerfilUtilizador() {
		return perfilUtilizador;
	}
	public void setPerfilUtilizador(PerfilUtilizador perfilUtilizador) {
		this.perfilUtilizador = perfilUtilizador;
	}
	
	
	
	

}
