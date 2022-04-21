package com.ujc.eswa.mensalidade.aeit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.eswa.mensalidade.aeit.model.Inscricao;
import com.ujc.eswa.mensalidade.aeit.repository.InscricaoRepository;

@RestController
@RequestMapping(value = "ujc-mensalidade/api/v1/incricoes")
@CrossOrigin
public class IncricaoController {
	
	@Autowired
	private InscricaoRepository inscricaoRepository;
	
	@GetMapping
	public ResponseEntity<List<Inscricao>> getAll(){
		List<Inscricao> inscricoesInscricaos = inscricaoRepository.findAll();
		if(!inscricoesInscricaos.isEmpty()) {
			ResponseEntity.ok().body(inscricoesInscricaos);
		}
		return ResponseEntity.notFound().build();
	}
}
