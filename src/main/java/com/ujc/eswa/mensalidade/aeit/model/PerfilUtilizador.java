package com.ujc.eswa.mensalidade.aeit.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PerfilUtilizador extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7943524067823582880L;
	
	
	@JsonIgnore
	@JoinColumn(name = "utilizador_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Utilizador utilizador;
	
	@Enumerated(EnumType.STRING)
	private Perfil perfil;

	
	public PerfilUtilizador() {
		super();
	}

	public PerfilUtilizador(Perfil perfil) {
		super();
		this.perfil = perfil;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
