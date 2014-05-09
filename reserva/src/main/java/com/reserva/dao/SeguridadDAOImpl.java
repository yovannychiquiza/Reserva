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

@Repository
public class SeguridadDAOImpl implements SeguridadDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<EmpleadoPermiso> getEmpleadoPermiso(int empleado) {		
		return getCurrentSession().createQuery("from EmpleadoPermiso").list();
		/*String hql = "from EmpleadoPermiso e where e.empleado_Id = :empleado_Id";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("empleado_Id",empleado);
		List<EmpleadoPermiso> lista = (List<EmpleadoPermiso>)query.list();
		return lista;*/
	}

}
