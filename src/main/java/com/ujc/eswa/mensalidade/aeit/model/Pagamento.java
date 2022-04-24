package com.ujc.eswa.mensalidade.aeit.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Entity
public class Pagamento extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6100198428559975555L;
	/*
	 * 
	 * status de pagamento
	 * 0-pago
	 * 1-nao paga
	 * 
	 * */
	private String dataPagamento;
	private Long status;
	@ManyToOne
	private Estudante estudante;
	
	
	public Pagamento() {
		super();
	}
	public String getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Estudante getEstudante() {
		return estudante;
	}
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
