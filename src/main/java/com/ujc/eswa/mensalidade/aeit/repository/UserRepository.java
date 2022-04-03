package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ujc.eswa.mensalidade.aeit.model.Utilizador;
@Repository
public interface UserRepository extends JpaRepository<Utilizador, Long>{
	
	public List<Utilizador> findAll();
	
	public Utilizador findByUserNameAndPassword(String userName,String password);
	
	public Utilizador findByIdAndPassword(Long id,String password);
	public Utilizador findByPassword(String password);
//	public Utilizador findByUsernameAndPassword(String userName,String password);

}

