package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujc.eswa.mensalidade.aeit.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
	
	public List<Pagamento> findAll();
	 
	public List<Pagamento> findAllByEstudanteId(Long estudanteId);
}
