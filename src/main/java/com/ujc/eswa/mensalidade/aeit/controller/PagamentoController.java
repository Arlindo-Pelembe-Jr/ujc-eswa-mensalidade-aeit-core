package com.ujc.eswa.mensalidade.aeit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.eswa.mensalidade.aeit.model.Pagamento;
import com.ujc.eswa.mensalidade.aeit.repository.PagamentoRepository;

@RestController
@RequestMapping(value="ujc-mensalidade/api/v1/pagamentos")
@CrossOrigin
public class PagamentoController {
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	@GetMapping
	public ResponseEntity<List<Pagamento>>  getAll(){
		List<Pagamento> listPaymentsList=pagamentoRepository.findAll();
		return ResponseEntity.ok().body(listPaymentsList);
	}
	
	@PostMapping
	public Pagamento createPayment(@RequestBody Pagamento pagamento) {
		System.out.println("To create payment");
		return pagamentoRepository.save(pagamento);
	}
}
