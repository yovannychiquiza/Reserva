package com.reserva.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="empleadopermiso")
public class EmpleadoPermiso {
	
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne()
	@JoinColumn(name = "Empleado_Id")
	private Empleado Empleado_Id;
	
	@ManyToOne()
	@JoinColumn(name = "Permiso_Id")
	private Permiso Permiso_Id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Empleado getEmpleado_Id() {
		return Empleado_Id;
	}

	public void setEmpleado_Id(Empleado empleado) {
		Empleado_Id = empleado;
	}

	public Permiso getPermiso_Id() {
		return Permiso_Id;
	}

	public void setPermiso_Id(Permiso permiso) {
		Permiso_Id = permiso;
	}

}
