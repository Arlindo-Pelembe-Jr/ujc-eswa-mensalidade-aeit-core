package com.ujc.eswa.mensalidade.aeit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.eswa.mensalidade.aeit.exception.ResourceNotFoundException;
import com.ujc.eswa.mensalidade.aeit.model.Estudante;
import com.ujc.eswa.mensalidade.aeit.repository.EstudanteRepository;

@RestController
@RequestMapping(value="ujc-mensalidade/api/v1/estudantes")
@CrossOrigin

public class EstudanteController {
	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@GetMapping
	public List<Estudante> listOfStudents(){
		return estudanteRepository.findAll();
	}
	
	@GetMapping("/byCoures")
	public ResponseEntity<List<Map<String, Object>>> listAllByCourse(){
		List<Map<String, Object>> dataList = new ArrayList<>();
//		Map<String, Object> dataObjectMap = new HashMap<>();
//		dataObjectMap.put("key", "value");
//		dataObjectMap.put("key1", "value1");
//		dataObjectMap.put("key2", "value2");
//
//
//		dataList.add(dataObjectMap);
		
		List<Estudante> studentsWithCourseEstudantes = estudanteRepository.findAll();
		studentsWithCourseEstudantes.forEach(e->{
			System.out.println(e.toString());
//			System.out.println(e.getCursoInfo().getCurso().getNome_curso()+e.getCursoInfo().getCurso().getCursoCodigo()+e.getCursoInfo().getCurso().getNome_curso());
			Map<String, Object> dataObjectMap = new HashMap<>();
			dataObjectMap.put("id", e.getId());
			dataObjectMap.put("nome", e.getNome());
			dataObjectMap.put("cod_estudante", e.getCod_estudante());
			dataObjectMap.put("curso", e.getCurso().getNome_curso());
			dataObjectMap.put("curso_codigo", e.getCurso().getCursoCodigo());
			dataList.add(dataObjectMap);

		});
		return ResponseEntity.ok().body(dataList);
	}
	@GetMapping("/{codEstudante}")
	public Estudante getStudentByCode(@PathVariable Long codEstudante) {
		return  estudanteRepository.findByCodEstudante(codEstudante);
	}
	@GetMapping("/{id}/estudante")
	public ResponseEntity<Estudante> getStudentById(@PathVariable Long id) throws ResourceNotFoundException  {
		Estudante student= estudanteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Estudante nao encontrado com id:"+id));
		
		return ResponseEntity.ok().body( estudanteRepository.save(student));
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
	@PostMapping("/{id}")
	public ResponseEntity<Estudante> updateStudentById(@RequestBody Estudante estudante,@PathVariable Long id) throws ResourceNotFoundException  {
		Estudante updateStudent= estudanteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Estudante nao encontrado com id:"+id));
		estudante.setId(updateStudent.getId());
		updateStudent = estudante;
		return ResponseEntity.ok().body( estudanteRepository.save(updateStudent));
	}
	  @RequestMapping(value = "/{codEstudante}", method = {RequestMethod.DELETE})
	  void deleteStudent(@PathVariable Long codEstudante) {
		  Estudante deleteStudent=estudanteRepository.findByCodEstudante(codEstudante);
		  estudanteRepository.delete(deleteStudent);
	  }
}
