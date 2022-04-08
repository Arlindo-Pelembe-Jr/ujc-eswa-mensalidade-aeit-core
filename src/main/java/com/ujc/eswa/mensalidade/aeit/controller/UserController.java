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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.eswa.mensalidade.aeit.model.Utilizador;

@RestController
@RequestMapping("ujc-mensalidade/api/v1")
@CrossOrigin
public class UserController {
//	@Autowired
//	private UserRepository userRepository;
//	
//	@GetMapping("/users")
//	@ResponseBody
//	public ResponseEntity<List<Utilizador>> getAllUsers(){
////		 userRepository.findAll();
//			return ResponseEntity.ok().body(userRepository.findAll());
//
//	}
//	
//	@GetMapping("/usersx/{userName}/{password}")
//	public Utilizador login(@PathVariable(value = "userName") String userName,@PathVariable(value = "password") String password ) {
//		Utilizador user=userRepository.findByUserNameContainingAndPasswordContaining(userName, password);
//		return user;
//	}
//	@GetMapping("/usersx/{id}/{password}")
//	public Utilizador login(@PathVariable(value = "id") Long id,@PathVariable(value = "password") String password ) {
//		userRepository.findById(id);
//		userRepository.findByPassword(password);
//		Utilizador user=userRepository.findByIdAndPassword(id, password);
//		return user;
//	}
//	@GetMapping("/login/{password}")
////	@RequestMapping(value = {"/users/{password}"}, method = RequestMethod.GET)
//	public Utilizador login(@RequestBody Utilizador utilizador ,@PathVariable(value = "password") String password ) {
//		
////		Utilizador user=userRepository.findByPassword(utilizador.get);
////		return user;
//	}
//	@GetMapping("/usersx/{id}")
////	@RequestMapping(value = {"/users/{id}"}, method = RequestMethod.GET)
//	public void login(@PathVariable(value = "id") Long id) {
//		userRepository.findById(id);
////		return user;
//	}
//	@PostMapping("/users")
//	public Utilizador sigin(@RequestBody Utilizador utilizador) {
//		return userRepository.save(utilizador);
//	}
}
