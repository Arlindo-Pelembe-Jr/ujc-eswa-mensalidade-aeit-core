package com.ujc.eswa.mensalidade.aeit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.eswa.mensalidade.aeit.exception.ResourceNotFoundException;
import com.ujc.eswa.mensalidade.aeit.model.Utilizador;
import com.ujc.eswa.mensalidade.aeit.repository.UtilizadorRepository;

@RestController
@RequestMapping(value="ujc-mensalidade/api/v1/utilizadores")
@CrossOrigin
public class UtilizadorController {
	@Autowired
	private UtilizadorRepository utilizadorRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Utilizador>> getAllUsers(){
//		 userRepository.findAll();
			return ResponseEntity.ok().body(utilizadorRepository.findAll());

	}
	
	@GetMapping("/{userName}/{senha}")
	public ResponseEntity<Utilizador> login(@PathVariable String userName,@PathVariable String senha ) {
		Utilizador user=utilizadorRepository.findByUserNameAndSenhaUtilizador(userName, senha);
		
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/login/{email}/{senha}")
	public ResponseEntity<Utilizador> authUser(@PathVariable String  email,@PathVariable String senha){
		Utilizador userUtilizador = utilizadorRepository.findByEmailAndSenhaUtilizador(email, senha);
		return ResponseEntity.ok().body(userUtilizador);
	}
	@GetMapping("/{id}/{senha}/search")
	public ResponseEntity<Utilizador> authetication(@PathVariable Long id,@PathVariable String senha ) throws ResourceNotFoundException {
//		Utilizador user= userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Utilizador nao encontrado"+id));
//		userRepository.findBySenhaUtilizador(senha);
		Utilizador user=utilizadorRepository.findByIdAndSenhaUtilizador(id, senha);
//		if(user.getSenha() == senha) {
			return ResponseEntity.ok().body(user);
//
//		}
//		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public Utilizador sigin(@RequestBody Utilizador utilizador) {
		System.out.println("To create current user: "+utilizador.getUserName());
		return utilizadorRepository.save(utilizador);
	}
	
	@PostMapping("/{id}")
	public Utilizador updateUser(@RequestBody Utilizador utilizador,@PathVariable Long id)throws ResourceNotFoundException {
		System.out.println("To update current user: "+utilizador.getUserName());
		Utilizador updateUtilizador = utilizadorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Utilizador nao encontrado"+id));
		utilizador.setId(updateUtilizador.getId());
		return utilizadorRepository.save(utilizador);
	}
}
