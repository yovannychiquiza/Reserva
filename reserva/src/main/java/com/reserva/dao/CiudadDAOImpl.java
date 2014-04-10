package com.reserva.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reserva.model.Ciudad;

@Repository
public class CiudadDAOImpl implements CiudadDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addCiudad(Ciudad ciudad) {
		getCurrentSession().save(ciudad);
	}

	public void updateCiudad(Ciudad ciudad) {
		Ciudad ciudadToUpdate = getCiudad(ciudad.getId());
		ciudadToUpdate.setNombre(ciudad.getNombre());		
		getCurrentSession().update(ciudadToUpdate);
		
	}

	public Ciudad getCiudad(int id) {
		Ciudad ciudad = (Ciudad) getCurrentSession().get(Ciudad.class, id);
		return ciudad;
	}

	public void deleteCiudad(int id) {
		Ciudad ciudad = getCiudad(id);
		if (ciudad != null)
			getCurrentSession().delete(ciudad);
	}

	@SuppressWarnings("unchecked")
	public List<Ciudad> getCiudads() {
		return getCurrentSession().createQuery("from Ciudad").list();
	}

}
