package com.ujc.eswa.mensalidade.aeit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.eswa.mensalidade.aeit.model.Utilizador;
import com.ujc.eswa.mensalidade.aeit.repository.UserRepository;

@RestController
@RequestMapping("ujc-mensalidade/api/v1")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	@ResponseBody
	public List<Utilizador> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{userName}/{password}")
	public Utilizador login(@PathVariable(value = "userName") String username,@PathVariable(value = "password") String password ) {
		Utilizador user=userRepository.findByUserNameAndPassword(username, password);
		return user;
	}
	@GetMapping("/users/{id}/{password}")
	public Utilizador login(@PathVariable(value = "id") Long id,@PathVariable(value = "password") String password ) {
		userRepository.findById(id);
		userRepository.findByPassword(password);
		Utilizador user=userRepository.findByIdAndPassword(id, password);
		return user;
	}
	@GetMapping("/users/{id}")
	public void login(@PathVariable(value = "id") Long id) {
		userRepository.findById(id);
//		return user;
	}
	@PostMapping("/users")
	public Utilizador sigin(@Valid @RequestBody Utilizador utilizador) {
		return userRepository.save(utilizador);
	}
}
