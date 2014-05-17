package com.reserva.dao;

import java.util.List;

import com.reserva.model.EmpleadoPermiso;
import com.reserva.model.Permiso;

public interface SeguridadDAO {
	public void addEmpleadoPermiso(EmpleadoPermiso empleadoPermiso);	
	public void deleteEmpleadoPermiso(EmpleadoPermiso empleadoPermiso);
	public EmpleadoPermiso getEmpleadoPermiso(int empleado_id, int permiso_id);
	public List<EmpleadoPermiso> getEmpleadoPermiso(int empleado);
	public List<Permiso> getPermiso();

}
