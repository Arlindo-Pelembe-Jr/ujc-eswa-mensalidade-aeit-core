package com.ujc.eswa.mensalidade.aeit.model;
import java.util.List;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Mensalidade extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9106421585970275155L;


	@ManyToOne
	private Pagamento pagamento;
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
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	@ManyToMany
	@JoinTable(name="pagamento_mensalidade", joinColumns=@JoinColumn(name="mensalidade_id"), inverseJoinColumns=@JoinColumn(name="estudante_id"))
	private List <Estudante> estudantes;

}
