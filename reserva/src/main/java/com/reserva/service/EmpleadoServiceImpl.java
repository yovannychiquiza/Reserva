package com.reserva.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reserva.dao.EmpleadoDAO;
import com.reserva.dao.SeguridadDAO;
import com.reserva.model.Empleado;
import com.reserva.model.EmpleadoPermiso;

/**
 * @author catalina
 *
 */
@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoDAO empleadoDAO;

	@Autowired
	private SeguridadDAO seguridadDAO;
	
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
	
	/**
	 * Se buscan los permisos configurados para el empleado
	 */
	public Empleado getEmpleadoPermiso(int id) {
		Empleado empleado = empleadoDAO.getEmpleado(id);
				
		List<EmpleadoPermiso> listaPermiso = seguridadDAO.getEmpleadoPermisoAll();
		for (EmpleadoPermiso permiso : listaPermiso) {

			for (EmpleadoPermiso permisoGuardado : empleado.getEmpleadoPermiso()) {
				if(permisoGuardado.getPermiso_Id() == permiso.getPermiso_Id()){
					permiso.setActivo(true);
					break;
				}
			}
			permiso.setNombrePermiso(permiso.getPermiso_Id().getNombre());
		}
		empleado.setEmpleadoPermisoAll(listaPermiso);
		return empleado;
	}

}
