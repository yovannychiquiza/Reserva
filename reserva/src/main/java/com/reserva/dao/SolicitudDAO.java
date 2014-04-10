package com.reserva.dao;

import java.util.List;

import com.reserva.model.Solicitud;

public interface SolicitudDAO {
	
	public void addSolicitud(Solicitud solicitud);
	public void updateSolicitud(Solicitud solicitud);
	public Solicitud getSolicitud(int id);
	public void deleteSolicitud(int id);
	public List<Solicitud> getSolicituds();

}
