package com.reserva.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reserva.dao.EmpleadoDAO;
import com.reserva.model.Empleado;

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoDAO empleadoDAO;

	public void addEmpleado(Empleado empleado) {
		Calendar cal = Calendar.getInstance();
		empleado.setFechaModificacion(cal.getTime());
		empleadoDAO.addEmpleado(empleado);		
	}

	public void updateEmpleado(Empleado empleado) {
		Calendar cal = Calendar.getInstance();
		empleado.setFechaModificacion(cal.getTime());
		empleadoDAO.updateEmpleado(empleado);
	}

	public Empleado getEmpleado(int id) {
		return empleadoDAO.getEmpleado(id);
	}

	public void deleteEmpleado(int id) {
		empleadoDAO.deleteEmpleado(id);
	}

	public List<Empleado> getEmpleados() {
		return empleadoDAO.getEmpleados();
	}

}
