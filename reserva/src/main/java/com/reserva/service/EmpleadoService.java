package com.reserva.service;

import java.util.List;

import com.reserva.model.Empleado;
import com.reserva.model.EmpleadoPermiso;

public interface EmpleadoService {
	
	public void addEmpleado(Empleado team);
	public void updateEmpleado(Empleado team);
	public Empleado getEmpleado(int id);
	public void deleteEmpleado(int id);
	public List<Empleado> getEmpleados();
	public Empleado getEmpleadoPermiso(int id);
}
