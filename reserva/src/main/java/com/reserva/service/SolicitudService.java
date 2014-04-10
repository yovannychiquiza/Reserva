package com.reserva.service;

import java.util.List;

import com.reserva.model.Ciudad;
import com.reserva.model.Solicitud;

public interface SolicitudService {
	
	public void addSolicitud(Solicitud model);
	public void updateSolicitud(Solicitud model);
	public Solicitud getSolicitud(int id);
	public void deleteSolicitud(int id);
	public List<Solicitud> getSolicituds();
	public List<Ciudad> getCiudades();

}
