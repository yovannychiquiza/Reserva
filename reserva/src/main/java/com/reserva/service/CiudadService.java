package com.reserva.service;

import java.util.List;

import com.reserva.model.Ciudad;

public interface CiudadService {
	
	public void addCiudad(Ciudad team);
	public void updateCiudad(Ciudad team);
	public Ciudad getCiudad(int id);
	public void deleteCiudad(int id);
	public List<Ciudad> getCiudads();

}
