package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ujc.eswa.mensalidade.aeit.model.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
	
	public List<Departamento> findAll();

}
