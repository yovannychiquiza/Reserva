package com.reserva.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reserva.model.Ciudad;
import com.reserva.model.Empleado;
import com.reserva.model.EmpleadoPermiso;
import com.reserva.model.Permiso;

@Repository
public class SeguridadDAOImpl implements SeguridadDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addEmpleadoPermiso(EmpleadoPermiso empleadoPermiso) {
		getCurrentSession().save(empleadoPermiso);
	}	
	
	public void deleteEmpleadoPermiso(EmpleadoPermiso empleadoPermiso) {		
		if (empleadoPermiso != null)
			getCurrentSession().delete(empleadoPermiso);
	}

	public EmpleadoPermiso getEmpleadoPermiso(int empleado_id, int permiso_id) {		
		String hql = "from EmpleadoPermiso e where e.Empleado_Id.id = :empleado_id and e.Permiso_Id.id = :permiso_id";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("empleado_id", empleado_id);
		query.setParameter("permiso_id", permiso_id);
		EmpleadoPermiso empleadoPermiso = (EmpleadoPermiso)query.uniqueResult();
		return empleadoPermiso;
	}

	public List<EmpleadoPermiso> getEmpleadoPermiso(int empleado) {		
		return getCurrentSession().createQuery("from EmpleadoPermiso").list();
		/*String hql = "from EmpleadoPermiso e where e.empleado_Id = :empleado_Id";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("empleado_Id",empleado);
		List<EmpleadoPermiso> lista = (List<EmpleadoPermiso>)query.list();
		return lista;*/
	}

	public List<Permiso> getPermiso() {		
		return getCurrentSession().createQuery("from Permiso").list();		
	}

}
