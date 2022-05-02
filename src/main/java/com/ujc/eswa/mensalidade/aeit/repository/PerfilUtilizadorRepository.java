package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ujc.eswa.mensalidade.aeit.model.PerfilUtilizador;

@Repository
public interface PerfilUtilizadorRepository extends JpaRepository<PerfilUtilizador, Long> {
	
	public List<PerfilUtilizador> findAll();

}
