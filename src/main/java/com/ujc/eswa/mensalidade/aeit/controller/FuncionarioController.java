package com.ujc.eswa.mensalidade.aeit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.eswa.mensalidade.aeit.model.Funcionario;
import com.ujc.eswa.mensalidade.aeit.repository.FuncionarioRepository;

@RestController
@RequestMapping(value = "ujc-mensalidade/api/v1/funcionarios")
@CrossOrigin
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> getAll(){
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		if(!funcionarios.isEmpty()) {
			return ResponseEntity.ok().body(funcionarios);
		}
		return ResponseEntity.notFound().build();
	}
}
