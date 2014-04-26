package com.reserva.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {
	
/*	@RequestMapping(value = "/")
	public String home(Model model) {
		
		model.addAttribute("CurrPrincipal",
			SecurityContextHolder.getContext()
				.getAuthentication().getName());
		
		return "index";
		x
	}
*///	@RequestMapping(value="/")
//	public ModelAndView mainPage() {
//		return new ModelAndView("home");
//	}
	
	/*@RequestMapping(value="/index")
	public ModelAndView indexPage() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/homeempleado")
	public ModelAndView homeempleado() {
		return new ModelAndView("homeempleado");
	}
*/
}
