package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ujc.eswa.mensalidade.aeit.model.Estudante;
@Repository
public interface EstudanteRepository extends JpaRepository<Estudante,Long>{
	
	public List<Estudante> findAll();
	
	public Estudante findByCodEstudante(Long codEstudante);
	
//	public Estudante findByIdEstudante(Long id);
}
