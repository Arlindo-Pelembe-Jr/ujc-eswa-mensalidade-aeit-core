package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ujc.eswa.mensalidade.aeit.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	
	public List<Professor> findAll();

}
