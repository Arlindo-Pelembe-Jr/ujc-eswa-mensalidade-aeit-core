package com.ujc.eswa.mensalidade.aeit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.eswa.mensalidade.aeit.model.Estudante;
import com.ujc.eswa.mensalidade.aeit.model.Inscricao;
import com.ujc.eswa.mensalidade.aeit.repository.EstudanteRepository;
import com.ujc.eswa.mensalidade.aeit.repository.InscricaoRepository;

@RestController
@RequestMapping(value = "ujc-mensalidade/api/v1/incricoes")
@CrossOrigin
public class IncricaoController {
	
	@Autowired
	private InscricaoRepository inscricaoRepository;
	@Autowired 
	private EstudanteRepository estudanteRepository;
	@GetMapping
	public ResponseEntity<List<Inscricao>> getAll(){
		List<Inscricao> inscricoesInscricaos = inscricaoRepository.findAll();
		if(!inscricoesInscricaos.isEmpty()) {
			return ResponseEntity.ok().body(inscricoesInscricaos);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/bystudent")
	public ResponseEntity<List<Inscricao>> getByStudent(@PathVariable Long utilizadorId){
		Estudante estudante = estudanteRepository.findEstudanteByUtilizadorId(utilizadorId);
		List<Inscricao> inscricoesInscricaos = inscricaoRepository.findAll();
		if(!inscricoesInscricaos.isEmpty()) {
			return ResponseEntity.ok().body(inscricoesInscricaos);
		}
		return ResponseEntity.notFound().build();
	}
}
