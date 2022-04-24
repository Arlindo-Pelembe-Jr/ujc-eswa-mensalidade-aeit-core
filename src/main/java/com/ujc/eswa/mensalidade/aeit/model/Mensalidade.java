package com.ujc.eswa.mensalidade.aeit.model;

import javax.persistence.Entity;

@Entity
public class Mensalidade extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9106421585970275155L;



	@Override
	public String toString() {
		return "Mensalidade []";
	}
	public Long getValorPago() {
		return valorPago;
	}
	public void setValorPago(Long valorPago) {
		this.valorPago = valorPago;
	}
	public Long getMulta() {
		return multa;
	}
	public void setMulta(Long multa) {
		this.multa = multa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private Long valorPago;
	private Long multa;
}
