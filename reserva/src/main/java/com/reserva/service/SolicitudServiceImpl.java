package com.reserva.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reserva.dao.CiudadDAO;
import com.reserva.dao.SolicitudDAO;
import com.reserva.model.Ciudad;
import com.reserva.model.EstadoSolicitud;
import com.reserva.model.Solicitud;
import com.reserva.service.Constantes.EnumEstadoSolictud;

@Service
@Transactional
public class SolicitudServiceImpl implements SolicitudService {
	
	@Autowired
	private SolicitudDAO solicitudDAO;
	
	@Autowired
	private CiudadDAO ciudadDAO;

	public void addSolicitud(Solicitud solicitud) {
		Calendar cal = Calendar.getInstance();
		solicitud.setFechaModificacion(cal.getTime());
		
		EstadoSolicitud estadoSolicitud = new EstadoSolicitud();
		estadoSolicitud.setId(EnumEstadoSolictud.Autorizacion_Seguridad.getValor());
		solicitud.setEstadoSolicitud_Id(estadoSolicitud);
		solicitudDAO.addSolicitud(solicitud);		
	}

	public void updateSolicitud(Solicitud solicitud) {
		Calendar cal = Calendar.getInstance();
		solicitud.setFechaModificacion(cal.getTime());
		EstadoSolicitud estadoSolicitud = new EstadoSolicitud();
		estadoSolicitud.setId(EnumEstadoSolictud.Autorizacion_Jefe.getValor());
		solicitud.setEstadoSolicitud_Id(estadoSolicitud);
		solicitudDAO.updateSolicitud(solicitud);
	}

	public Solicitud getSolicitud(int id) {
		return solicitudDAO.getSolicitud(id);
	}

	public void deleteSolicitud(int id) {
		solicitudDAO.deleteSolicitud(id);
	}

	public List<Solicitud> getSolicituds() {
		return solicitudDAO.getSolicituds();
	}

	public List<Ciudad> getCiudades() {
		return ciudadDAO.getCiudads();
	}

}
