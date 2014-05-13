package com.reserva.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reserva.dao.CiudadDAO;
import com.reserva.model.Ciudad;

@Service
@Transactional
public class CiudadServiceImpl implements CiudadService {
	
	@Autowired
	private CiudadDAO ciudadDAO;

	public void addCiudad(Ciudad ciudad) {
		Calendar cal = Calendar.getInstance();		
		ciudadDAO.addCiudad(ciudad);		
	}

	public void updateCiudad(Ciudad ciudad) {
		Calendar cal = Calendar.getInstance();		
		ciudadDAO.updateCiudad(ciudad);
	}

	public Ciudad getCiudad(int id) {
		return ciudadDAO.getCiudad(id);
	}

	public void deleteCiudad(int id) {
		ciudadDAO.deleteCiudad(id);
	}

	public List<Ciudad> getCiudads() {
		return ciudadDAO.getCiudads();
	}

}
