package com.ujc.eswa.mensalidade.aeit.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.ujc.eswa.mensalidade.aeit.model.Estudante;
import com.ujc.eswa.mensalidade.aeit.model.Mensalidade;
import com.ujc.eswa.mensalidade.aeit.model.Pagamento;
import com.ujc.eswa.mensalidade.aeit.repository.EstudanteRepository;
import com.ujc.eswa.mensalidade.aeit.repository.MensalidadeRepository;
import com.ujc.eswa.mensalidade.aeit.repository.PagamentoRepository;
import com.ujc.eswa.mensalidade.aeit.service.PDFGeneratorPayments;

@RestController
@RequestMapping(value="ujc-mensalidade/api/v1/pagamentos")
@CrossOrigin
public class PagamentoController {
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private MensalidadeRepository mensalidadeRepository;
	
	@Autowired 
	private EstudanteRepository estudanteRepository;
	@GetMapping
	public ResponseEntity<List<Pagamento>>  getAll(){
		List<Pagamento> listPaymentsList=pagamentoRepository.findAll();
		return ResponseEntity.ok().body(listPaymentsList);
	}
	
	@GetMapping("/report")
	public void  generatePdf(HttpServletResponse response)throws DocumentException,IOException{
		
		response.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("YYY-MM-DD:HH:MM:SS");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);
		List<Pagamento> listPaymentsList=pagamentoRepository.findAll();
		
		PDFGeneratorPayments generatorPdf = new PDFGeneratorPayments();
		generatorPdf.setPaymentsList(listPaymentsList);
		generatorPdf.generate(response);
//		return ResponseEntity.ok().body(listPaymentsList);
	}
//	@PostMapping
//	public Pagamento createPayment(@RequestBody Pagamento pagamento) {
//		System.out.println("To create payment");
//		return pagamentoRepository.save(pagamento);
//	}
	@PostMapping("/mensalidade/{amount}")
	public Pagamento createPaymentWithMounthly(@PathVariable("amount") Long amount,@RequestBody Pagamento pagamento) {
		System.out.println("To create payment with "+" amount: "+amount);
		
		Estudante estudante = estudanteRepository.findById(pagamento.getEstudante().getId()).orElseThrow(null);
		pagamento.setEstudante(estudante);
		Pagamento payment= pagamentoRepository.save(pagamento);

		System.out.println("payment:"+payment);
	
		System.out.println("founded student"+estudante.getNome());
		Mensalidade mensalidade = new Mensalidade();
		mensalidade.setValorPago(amount);
		mensalidade.setPagamento(payment);
		mensalidadeRepository.save(mensalidade);
		return payment;
	}
}
