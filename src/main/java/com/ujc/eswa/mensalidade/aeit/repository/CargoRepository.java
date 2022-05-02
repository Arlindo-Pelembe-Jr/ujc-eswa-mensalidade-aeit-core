package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ujc.eswa.mensalidade.aeit.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{
	
	public List<Cargo> findAll();
}
