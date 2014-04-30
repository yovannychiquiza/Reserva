package com.reserva.dao;

import java.util.List;

import com.reserva.model.Empleado;

public interface EmpleadoDAO {
	
	public void addEmpleado(Empleado empleado);
	public void updateEmpleado(Empleado empleado);
	public Empleado getEmpleado(int id);
	public Empleado getEmpleado(String usuario);
	public void deleteEmpleado(int id);
	public List<Empleado> getEmpleados();

}
