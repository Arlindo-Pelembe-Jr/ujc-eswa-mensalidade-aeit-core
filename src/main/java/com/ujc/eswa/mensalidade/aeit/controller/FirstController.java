package com.ujc.eswa.mensalidade.aeit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujc.eswa.mensalidade.aeit.model.Estudante;
import com.ujc.eswa.mensalidade.aeit.service.Service;

@Controller
public class FirstController {
	
	private Service service;
	
	public FirstController(Service service) {
		super();
		this.service = service;
	}

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		Estudante antonio = new Estudante("Antonio",1001);
		service.ative(antonio);
		return "Hello, Guys";
	}
	
	
}
