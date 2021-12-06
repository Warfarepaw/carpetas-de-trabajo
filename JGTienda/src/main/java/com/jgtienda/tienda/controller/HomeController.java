package com.jgtienda.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@ResponseBody 
	@GetMapping("/")
	public String mostrarIndex(Model model) 
	{
		return "home";
	} 
	
}
