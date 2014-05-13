package com.reserva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reserva.model.Ciudad;
import com.reserva.service.CiudadService;

@Controller
@RequestMapping(value="/ciudad")
public class CiudadController {
	
	@Autowired
	private CiudadService ciudadService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addCiudadPage() {
		ModelAndView modelAndView = new ModelAndView("ciudad/add-ciudad-form");
		modelAndView.addObject("ciudad", new Ciudad());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingCiudad(@ModelAttribute Ciudad ciudad) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/ciudad/list");
		ciudadService.addCiudad(ciudad);
		
		String message = "El Ciudad fue satisfactoriamente creado.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfCiudads() {
		ModelAndView modelAndView = new ModelAndView("ciudad/list-of-ciudads");
		
		List<Ciudad> ciudads = ciudadService.getCiudads();
		modelAndView.addObject("ciudads", ciudads);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editCiudadPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("ciudad/edit-ciudad-form");
		Ciudad ciudad = ciudadService.getCiudad(id);
		modelAndView.addObject("ciudad",ciudad);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingCiudad(@ModelAttribute Ciudad ciudad, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/ciudad/list");
		
		ciudadService.updateCiudad(ciudad);
		
		String message = "El Ciudad fue satisfactoriamente editado.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteCiudad(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/ciudad/list");
		ciudadService.deleteCiudad(id);
		String message = "El Ciudad fue satisfactoriamente borrado.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
