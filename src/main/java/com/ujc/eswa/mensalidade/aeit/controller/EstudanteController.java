package com.ujc.eswa.mensalidade.aeit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.eswa.mensalidade.aeit.model.Estudante;
import com.ujc.eswa.mensalidade.aeit.repository.EstudanteRepository;

@RestController
@RequestMapping(value="ujc-mensalidade/api/v1/estudantes")
public class EstudanteController {
	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@GetMapping
	public List<Estudante> listOfStudents(){
		return estudanteRepository.findAll();
	}
	
	@GetMapping("/{codEstudante}")
	public Estudante getStudentByCode(@PathVariable Long codEstudante) {
		return  estudanteRepository.findByCodEstudante(codEstudante);
	}
}
