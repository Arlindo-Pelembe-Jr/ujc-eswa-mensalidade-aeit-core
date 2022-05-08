package com.ujc.eswa.mensalidade.aeit.dto;

import java.io.Serializable;

public class AuthRequestDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8742162276591156539L;

	private String email;
	private String senha;
	
	
	
	
	public AuthRequestDTO() {
		super();
	}
	public AuthRequestDTO(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
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
	
	

}
