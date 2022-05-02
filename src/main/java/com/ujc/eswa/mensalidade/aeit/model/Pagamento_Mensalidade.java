package com.ujc.eswa.mensalidade.aeit.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="pagamento_mensalidade")
public class Pagamento_Mensalidade {
	@Id
	@Column(name="cod_pagamento")
	private Long codPagamento;
	@Column(name="data_pagamento")
	private Date data_pagamento;
	
}
