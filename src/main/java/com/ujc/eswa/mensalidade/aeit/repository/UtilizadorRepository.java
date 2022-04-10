package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ujc.eswa.mensalidade.aeit.model.Utilizador;
@Repository
public interface UtilizadorRepository extends JpaRepository<Utilizador, Long>{
	public List<Utilizador> findAll();
	
	@Query(value="SELECT * FROM Utilizador WHERE nome = nome AND senha = senha", nativeQuery=true)
	public Utilizador findByNomeAndSenhaUtilizador (String nome,String senha);
	@Query(value="SELECT * FROM Utilizador WHERE user_name LIKE %:user_name% AND senha LIKE %:senha%", nativeQuery=true)
	public Utilizador findByUserNameAndSenhaUtilizador(@Param("user_name") String user_name,@Param("senha") String senha);
	
	@Query(value="SELECT * FROM Utilizador WHERE id = id AND senha = senha", nativeQuery=true)
	public Utilizador findByIdAndSenhaUtilizador(Long id,String senha);
	
	public Utilizador findBySenha(String senha);

}
