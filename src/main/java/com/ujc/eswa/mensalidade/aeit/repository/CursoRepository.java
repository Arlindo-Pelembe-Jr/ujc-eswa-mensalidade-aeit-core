package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ujc.eswa.mensalidade.aeit.model.Curso;
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
	
	public List<Curso> findAll();
	

}
