package com.reserva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SeguridadController {
	
	@RequestMapping(method=RequestMethod.GET, value="/home")
	public String handleRequest(){
		return "home";
	}

	@RequestMapping(method=RequestMethod.GET, value="/")
	public String handleRequest1(){
		return "home";
	}

	@RequestMapping(method=RequestMethod.GET, value="/login")
	public String displayLoginPage(){
		return "login";
	}
	
	@RequestMapping(value="/login", params="errorLogin")
	public String directToLoginPageWithError(Model model){
		// Adding an attribute to flag that an error happened at login
		model.addAttribute("loginFailed", true);
		return "login";
	}
}
