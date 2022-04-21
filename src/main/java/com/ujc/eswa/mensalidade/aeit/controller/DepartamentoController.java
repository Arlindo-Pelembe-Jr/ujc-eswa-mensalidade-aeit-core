package com.ujc.eswa.mensalidade.aeit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.eswa.mensalidade.aeit.model.Departamento;
import com.ujc.eswa.mensalidade.aeit.repository.DepartamentoRepository;

@RestController
@RequestMapping(value = "ujc-mensalidade/api/v1/departamentos")
@CrossOrigin
public class DepartamentoController {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@GetMapping
	public ResponseEntity<List<Departamento>> getAll(){
		List<Departamento> departamentos = departamentoRepository.findAll();
		if(!departamentos.isEmpty()) {
			return ResponseEntity.ok().body(departamentos);
		}
		return ResponseEntity.notFound().build();
	}

}
