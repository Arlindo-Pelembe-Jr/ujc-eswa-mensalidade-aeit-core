package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ujc.eswa.mensalidade.aeit.model.Estudante;
@Repository
public interface EstudanteRepository extends JpaRepository<Estudante,Long>{
	
	public List<Estudante> findAll();
	
	public Estudante findByCodEstudante(Long codEstudante);
	
	@Query(value = "SELECT max(codEstudante) FROM Estudante")
	public Long findMaxCodEstudante();
//	public Estudante findByIdEstudante(Long id);
}
