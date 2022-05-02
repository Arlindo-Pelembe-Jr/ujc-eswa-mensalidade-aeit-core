package com.ujc.eswa.mensalidade.aeit.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="mensalidade")
public class Mensalidade {
	
	@Column(name="multa" )
	private Long multa;
	@Id
	@Column(name="cod_mensalidade")
	private Long codMensalidade;
	@Column(name="valor_pago")
	private Long valorPago;
	
	@ManyToMany
	@JoinTable(name="pagamento_mensalidade", joinColumns=@JoinColumn(name="mensalidade_id"), inverseJoinColumns=@JoinColumn(name="estudante_id"))
	private List <Estudante> estudantes;

	public Long getMulta() {
		return multa;
	}

	public void setMulta(Long multa) {
		this.multa = multa;
	}

	public Long getCodMensalidade() {
		return codMensalidade;
	}

	public void setCodMensalidade(Long codMensalidade) {
		this.codMensalidade = codMensalidade;
	}

	public Long getValorPago() {
		return valorPago;
	}

	public void setValorPago(Long valorPago) {
		this.valorPago = valorPago;
	}

	public List<Estudante> getEstudantes() {
		return estudantes;
	}

	public void setEstudantes(List<Estudante> estudantes) {
		this.estudantes = estudantes;
	}

}
