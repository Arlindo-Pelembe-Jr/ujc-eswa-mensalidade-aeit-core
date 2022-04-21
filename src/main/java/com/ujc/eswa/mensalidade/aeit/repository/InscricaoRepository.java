package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ujc.eswa.mensalidade.aeit.model.Inscricao;


@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long>{
	
	public List<Inscricao> findAll();

}
