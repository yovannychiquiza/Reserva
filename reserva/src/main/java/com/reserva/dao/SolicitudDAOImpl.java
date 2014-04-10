package com.reserva.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reserva.model.Solicitud;

@Repository
public class SolicitudDAOImpl implements SolicitudDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addSolicitud(Solicitud solicitud) {
		getCurrentSession().save(solicitud);
	}

	public void updateSolicitud(Solicitud solicitud) {
		Solicitud solicitudToUpdate = getSolicitud(solicitud.getId());
		//solicitudToUpdate.setCiudadDestino_Id(solicitud.getCiudadDestino_Id());
		//solicitudToUpdate.setCiudadOrigen_Id(solicitud.getCiudadOrigen_Id());
		solicitudToUpdate.setEstadoSolicitud_Id(solicitud.getEstadoSolicitud_Id());		
		getCurrentSession().update(solicitudToUpdate);
		
	}

	public Solicitud getSolicitud(int id) {
		Solicitud solicitud = (Solicitud) getCurrentSession().get(Solicitud.class, id);
		return solicitud;
	}

	public void deleteSolicitud(int id) {
		Solicitud solicitud = getSolicitud(id);
		if (solicitud != null)
			getCurrentSession().delete(solicitud);
	}

	@SuppressWarnings("unchecked")
	public List<Solicitud> getSolicituds() {
		return getCurrentSession().createQuery("from Solicitud").list();
	}

}
