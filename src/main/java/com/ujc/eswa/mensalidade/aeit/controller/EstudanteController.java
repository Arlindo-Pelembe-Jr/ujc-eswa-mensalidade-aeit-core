package com.ujc.eswa.mensalidade.aeit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@PostMapping
	public Estudante createStudent(@RequestBody Estudante estudante)  {
		System.out.println("to create current student: "+estudante.getNome());
		return estudanteRepository.save(estudante);
	}
	
	@PostMapping("/{codEstudante}")
	public Estudante updateStudent(@RequestBody Estudante estudante,@PathVariable Long codEstudante)  {
		Estudante updateStudent= estudanteRepository.findByCodEstudante(codEstudante);
//		updateStudent.setNome(estudante.getNome());
		updateStudent = estudante;

		return estudanteRepository.save(updateStudent);
	}
//	@PostMapping("/{id}")
//	public Estudante updateStudentById(@RequestBody Estudante estudante,@PathVariable Long id)  {
//		Optional<Estudante> updateStudent= estudanteRepository.findById(id);
////		updateStudent.setNome(estudante.getNome());
//		updateStudent = estudante;
//		return estudanteRepository.save(updateStudent);
//	}
	  @RequestMapping(value = "/{codEstudante}", method = {RequestMethod.DELETE})
	  void deleteStudent(@PathVariable Long codEstudante) {
		  Estudante deleteStudent=estudanteRepository.findByCodEstudante(codEstudante);
		  estudanteRepository.delete(deleteStudent);
	  }
}
