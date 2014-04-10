package com.reserva.dao;

import java.util.List;

import com.reserva.model.Ciudad;

public interface CiudadDAO {
	
	public void addCiudad(Ciudad model);
	public void updateCiudad(Ciudad model);
	public Ciudad getCiudad(int id);
	public void deleteCiudad(int id);
	public List<Ciudad> getCiudads();

}
