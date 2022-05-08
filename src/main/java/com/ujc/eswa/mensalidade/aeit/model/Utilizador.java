package com.ujc.eswa.mensalidade.aeit.model;

import java.beans.Transient;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public  class Utilizador extends BaseEntity implements UserDetails{

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
	
	@Column
	private String confirmationToken;
	@Column
	private String textPassword;
	
	@Column
	private boolean accountNonExpired;

	@Column
	private boolean accountNonLocked;

	@Column
	private boolean credentialsNonExpired;

	@Column
	private boolean enabled;
	@OneToMany(mappedBy = "utilizador", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<PerfilUtilizador> perfiSet =new HashSet<>();
	
	
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getTextPassword() {
		return textPassword;
	}

	public void setTextPassword(String textPassword) {
		this.textPassword = textPassword;
	}
	public Set<PerfilUtilizador> getPerfiSet() {
		return perfiSet;
	}
	public void setPerfiSet(Set<PerfilUtilizador> perfiSet) {
		this.perfiSet = perfiSet;
	}
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
	
	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		this.perfiSet.forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getPerfil().name()));
		});
		return authorities;	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.getSenha();
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Transient
	public void addRole(PerfilUtilizador role) {
		role.setUtilizador(this);
		this.perfiSet.add(role);
	}


	

}
