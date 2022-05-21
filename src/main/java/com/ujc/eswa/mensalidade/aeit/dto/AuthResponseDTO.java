package com.ujc.eswa.mensalidade.aeit.dto;

import java.io.Serializable;
import java.util.Set;

import com.ujc.eswa.mensalidade.aeit.model.PerfilUtilizador;

public class AuthResponseDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4503409317502045024L;

	private String nome;
	private String username;
	private String token;
	private Long userId;
	
	
	public AuthResponseDTO(String nome, String username, String token) {
		super();
		this.nome = nome;
		this.username = username;
		this.token = token;
	}
	
	public AuthResponseDTO(String nome, String username, String token, Long userId) {
		super();
		this.nome = nome;
		this.username = username;
		this.token = token;
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private Set<PerfilUtilizador> perfilUtilizadors;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Set<PerfilUtilizador> getPerfilUtilizadors() {
		return perfilUtilizadors;
	}
	public void setPerfilUtilizadors(Set<PerfilUtilizador> perfilUtilizadors) {
		this.perfilUtilizadors = perfilUtilizadors;
	}
	
	
}
