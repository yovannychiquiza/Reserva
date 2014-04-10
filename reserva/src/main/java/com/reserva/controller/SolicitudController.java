package com.reserva.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.reserva.model.Ciudad;
import com.reserva.model.Solicitud;
import com.reserva.service.SolicitudService;

@Controller
@RequestMapping(value="/solicitud")
public class SolicitudController {
	
	@Autowired
	private SolicitudService solicitudService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addSolicitudPage() {
		ModelAndView modelAndView = new ModelAndView("solicitud/add-solicitud-form");
		modelAndView.addObject("solicitud", new Solicitud());
		modelAndView.addObject("listaCiudades", referenceData());
		return modelAndView;
	}
	
	//SimpleFormController
		protected Map referenceData() {
			
			List<Ciudad> lista = solicitudService.getCiudades();
			Map<Integer,String> country = new LinkedHashMap<Integer,String>();
			
			for (Ciudad ciudad : lista) {
				country.put(ciudad.getId(), ciudad.getNombre());				
			}				
			return country;
		}
		
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingSolicitud(@ModelAttribute Solicitud solicitud) {
		
		ModelAndView modelAndView = new ModelAndView("solicitud/list-of-solicitud");
		solicitudService.addSolicitud(solicitud);
		
		String message = "El Solicitud fue satisfactoriamente creado.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfSolicituds() {
		ModelAndView modelAndView = new ModelAndView("solicitud/list-of-solicitud");
		
		List<Solicitud> solicituds = solicitudService.getSolicituds();
		modelAndView.addObject("solicitudes", solicituds);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editSolicitudPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-solicitud-form");
		Solicitud solicitud = solicitudService.getSolicitud(id);
		modelAndView.addObject("solicitud",solicitud);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingSolicitud(@ModelAttribute Solicitud solicitud, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("solicitud/list-of-solicitud");
		
		solicitudService.updateSolicitud(solicitud);
		
		String message = "El Solicitud fue satisfactoriamente editado.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteSolicitud(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("homesolicitud");
		solicitudService.deleteSolicitud(id);
		String message = "El Solicitud fue satisfactoriamente borrado.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	

}
