package com.ujc.eswa.mensalidade.aeit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.eswa.mensalidade.aeit.model.Curso;
import com.ujc.eswa.mensalidade.aeit.repository.CursoRepository;

@RestController
@RequestMapping (value = "ujc-mensalidade/api/v1/cursos")
@CrossOrigin
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public ResponseEntity<List<Curso>> getAll(){
		List<Curso> cursos = cursoRepository.findAll();
	return	ResponseEntity.ok().body(cursos);
		
	}

}
