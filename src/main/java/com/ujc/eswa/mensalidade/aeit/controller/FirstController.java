package com.ujc.eswa.mensalidade.aeit.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.eswa.mensalidade.aeit.service.Service;

@RestController
@RequestMapping("ujc-mensalidade/api/v1")
@CrossOrigin
public class FirstController {
	
	private Service service;

	public FirstController(Service service) {
		super();
		this.service = service;
	}

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
//		Estudante antonio = new Estudante("Antonio",1001);
//		service.ative(antonio);

		return "Hello, Guys";
	}
//	@GetMapping("/students")
//	@ResponseBody
//	public List<Estudante> estudantes(){
//	 List<Estudante> ests =estudanteRepositorio.findAll();
//	 for (Estudante estudante : ests) {
////			System.out.println("\nCod estudante:"+estudante.getCod_estudante() +"nome:"+estudante.getNome());
//		}
//	 return ests;
//	}
//	
//	@PostMapping("/students")
//	public Estudante createStudent(@RequestBody Estudante estudante)  {
////		System.out.println("to create current student: "+estudante.getNome());
//		return estudanteRepositorio.save(estudante);
//	}
//
////	@PutMapping("/students/{id}")
////	Estudante updateStudent(@RequestBody Estudante estudante,@PathVariable Long codEstudante) {
////		Estudante updateStudent= estRepo.findByCodEstudante(codEstudante);
////		updateStudent.setNome(estudante.getNome());
////		return estRepo.save(updateStudent);
////	}
//	@GetMapping("/students/{codEstudante}")
//	@ResponseBody
//	public Estudante getStudentById(@RequestBody Estudante estudante,@PathVariable Long codEstudante)  {
//		return estudanteRepositorio.findByCodEstudante(codEstudante);
//
//	}
//	@PostMapping("/students/{id}")
//	public Estudante updateStudent(@RequestBody Estudante estudante,@PathVariable Long codEstudante)  {
//		Estudante updateStudent= estudanteRepositorio.findByCodEstudante(codEstudante);
////		updateStudent.setNome(estudante.getNome());
//		return estudanteRepositorio.save(updateStudent);
//	}
//	
//	  @RequestMapping(value = "/students/{id}", method = {RequestMethod.DELETE})
//	  @ResponseBody
//	  void deleteStudent(@PathVariable Long codEstudante) {
//		  Estudante deleteStudent=estudanteRepositorio.findByCodEstudante(codEstudante);
//	    estudanteRepositorio.delete(deleteStudent);
//	  }
}
