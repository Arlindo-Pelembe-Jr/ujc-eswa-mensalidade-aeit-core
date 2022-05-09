package com.ujc.eswa.mensalidade.aeit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.eswa.mensalidade.aeit.dto.SignupRequestDTO;
import com.ujc.eswa.mensalidade.aeit.model.Utilizador;
import com.ujc.eswa.mensalidade.aeit.service.UtilizadorService;



@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Autowired
	private UtilizadorService userService;

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody SignupRequestDTO requestDTO) throws Exception {
		Utilizador user = userService.registerUser(requestDTO);
		return ResponseEntity.ok().body(user.getConfirmationToken()); // TODO: review return type. Consider returning
																		// the URI
	}

	
}
