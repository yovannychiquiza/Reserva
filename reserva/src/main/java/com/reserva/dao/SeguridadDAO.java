package com.reserva.dao;

import java.util.List;

import com.reserva.model.EmpleadoPermiso;

public interface SeguridadDAO {
		
	public List<EmpleadoPermiso> getEmpleadoPermiso(int empleado);
	public List<EmpleadoPermiso> getEmpleadoPermisoAll();

}
