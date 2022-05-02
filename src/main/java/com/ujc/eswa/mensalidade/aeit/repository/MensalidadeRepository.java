package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ujc.eswa.mensalidade.aeit.model.Mensalidade;
@Repository
public interface MensalidadeRepository extends JpaRepository<Mensalidade, Long>{
	
	public List<Mensalidade> findAll();
	
	public Mensalidade findByPagamentoId(Long id);

}
