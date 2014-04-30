package com.reserva.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reserva.model.Empleado;

@Repository
public class EmpleadoDAOImpl implements EmpleadoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEmpleado(Empleado empleado) {
		getCurrentSession().save(empleado);
	}

	public void updateEmpleado(Empleado empleado) {
		Empleado empleadoToUpdate = getEmpleado(empleado.getId());
		empleadoToUpdate.setNombre(empleado.getNombre());
		empleadoToUpdate.setApellido(empleado.getApellido());
		getCurrentSession().update(empleadoToUpdate);
		
	}

	public Empleado getEmpleado(int id) {
		Empleado empleado = (Empleado) getCurrentSession().get(Empleado.class, id);
		return empleado;
	}

	public Empleado getEmpleado(String usuario) {		
		String hql = "from Empleado e where e.usuario = :usuario";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("usuario",usuario);
		Empleado empleado = (Empleado)query.uniqueResult();
		return empleado;
	}

	public void deleteEmpleado(int id) {
		Empleado empleado = getEmpleado(id);
		if (empleado != null)
			getCurrentSession().delete(empleado);
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> getEmpleados() {
		return getCurrentSession().createQuery("from Empleado").list();
	}

}
