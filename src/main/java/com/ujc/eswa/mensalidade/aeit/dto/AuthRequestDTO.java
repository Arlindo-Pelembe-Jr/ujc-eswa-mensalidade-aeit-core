package com.ujc.eswa.mensalidade.aeit.dto;

import java.io.Serializable;

public class AuthRequestDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8742162276591156539L;

	private String username;
	private String password;
	
	
	
	
	public AuthRequestDTO() {
		super();
	}
	public AuthRequestDTO(String email, String senha) {
		super();
		this.username = email;
		this.password = senha;
	}
	public String getEmail() {
		return username;
	}
	public void setEmail(String email) {
		this.username = email;
	}
	public String getSenha() {
		return password;
	}
	public void setSenha(String senha) {
		this.password = senha;
	}
	
	

}
