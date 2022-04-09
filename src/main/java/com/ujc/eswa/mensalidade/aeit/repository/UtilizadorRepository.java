package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujc.eswa.mensalidade.aeit.model.Utilizador;

public interface UtilizadorRepository extends JpaRepository<Utilizador, Long>{
	public List<Utilizador> findAll();
	
	public Utilizador findByNomeAndSenhaUtilizador (String nome,String senha);
	
	public Utilizador findByUserNameAndSenha(String userName,String senha);

}
