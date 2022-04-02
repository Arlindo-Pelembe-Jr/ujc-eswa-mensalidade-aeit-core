package com.ujc.eswa.mensalidade.aeit.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ujc.eswa.mensalidade.aeit.model.Estudante;

@Component
public class EstudanteRepository {
	@PersistenceContext
	private EntityManager manager;
	
	public List<Estudante> students(){
		return manager.createQuery("from estudante",Estudante.class)
				.getResultList();
				
	}
	@Transactional
	public Estudante adicionar(Estudante estudante) {
		return manager.merge(estudante);
	}
}
