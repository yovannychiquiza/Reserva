package com.reserva.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reserva.model.Ciudad;
import com.reserva.model.Empleado;
import com.reserva.model.Solicitud;
import com.reserva.security.UserDetailsImpl;
import com.reserva.service.Constantes.EnumEstadoSolictud;
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
		
		UserDetailsImpl principal = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();		
		Empleado empleado = new Empleado();
		empleado.setUsuario(principal.getUsername());
		solicitud.setEmpleado(empleado);
		
		ModelAndView modelAndView = new ModelAndView("redirect:/solicitud/list");
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
	
	@RequestMapping(value="/seguridad/{id}", method=RequestMethod.GET)
	public ModelAndView editSolicitudPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("solicitud/edit-solicitud-form");
		Solicitud solicitud = solicitudService.getSolicitud(id);
		solicitud.setTipoEstado(EnumEstadoSolictud.Autorizacion_Seguridad.getValor());
		modelAndView.addObject("listaCiudades", referenceData());
		modelAndView.addObject("solicitud",solicitud);
		return modelAndView;
	}

	@RequestMapping(value="/jefe/{id}", method=RequestMethod.GET)
	public ModelAndView editSolicitudPage1(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("solicitud/edit-solicitud-form");
		Solicitud solicitud = solicitudService.getSolicitud(id);
		solicitud.setTipoEstado(EnumEstadoSolictud.Autorizacion_Jefe.getValor());
		modelAndView.addObject("listaCiudades", referenceData());
		modelAndView.addObject("solicitud",solicitud);
		return modelAndView;
	}

	@RequestMapping(value="/gerencia/{id}", method=RequestMethod.GET)
	public ModelAndView editSolicitudPage2(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("solicitud/edit-solicitud-form");
		Solicitud solicitud = solicitudService.getSolicitud(id);
		solicitud.setTipoEstado(EnumEstadoSolictud.Autorizacion_Gerencia.getValor());
		modelAndView.addObject("listaCiudades", referenceData());
		modelAndView.addObject("solicitud",solicitud);
		return modelAndView;
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingSolicitudseguridad(@ModelAttribute Solicitud solicitud, @PathVariable Integer id) {		
		ModelAndView modelAndView = new ModelAndView("redirect:/solicitud/list");			
		solicitudService.autorizacion(solicitud);		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteSolicitud(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/solicitud/list");
		solicitudService.deleteSolicitud(id);
		String message = "El Solicitud fue satisfactoriamente borrado.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	

}
