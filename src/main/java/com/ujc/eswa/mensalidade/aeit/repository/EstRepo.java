package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ujc.eswa.mensalidade.aeit.model.Estudante;

@Repository
public interface EstRepo extends JpaRepository<Estudante, Long>{
//	@Query("SELECT * FROM estudante")
	public List<Estudante> findAll();
	public Estudante findByCodEstudante(Long codEstudante);
//	public Optional<Estudante> findById(Long codEstudante);
}
