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
import com.reserva.model.Permiso;

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
				
		List<Permiso> listaPermiso = seguridadDAO.getPermiso();
		for (Permiso permiso : listaPermiso) {

			for (EmpleadoPermiso permisoGuardado : empleado.getEmpleadoPermiso()) {
				if(permisoGuardado.getPermiso_Id().getId() == permiso.getId()){
					permiso.setActivo(true);
					break;
				}
			}			
		}
		empleado.setPermiso(listaPermiso);
		return empleado;
	}

	@Override
	public void guardarPermiso(int empleado_id, int permiso_id, boolean activo) {
		
		EmpleadoPermiso empleadoPermisoGuardado = seguridadDAO.getEmpleadoPermiso(empleado_id, permiso_id);
		//Si no existe el permiso y esta seleccionado, entonces se crea
		if(empleadoPermisoGuardado == null && activo){
			
			EmpleadoPermiso empleadoPermiso = new EmpleadoPermiso();
			Empleado empleado = new Empleado();
			Permiso permiso = new Permiso();
			
			empleado.setId(empleado_id);
			permiso.setId(permiso_id);
			
			empleadoPermiso.setEmpleado_Id(empleado);
			empleadoPermiso.setPermiso_Id(permiso);
			seguridadDAO.addEmpleadoPermiso(empleadoPermiso);
		}
		//Si ya existe el permiso y esta desseleccionado, entonces se borra
		if(empleadoPermisoGuardado != null && !activo){
			seguridadDAO.deleteEmpleadoPermiso(empleadoPermisoGuardado);
		}
				
	}

}
