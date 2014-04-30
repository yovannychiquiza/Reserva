package com.reserva.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="solicitud")
public class Solicitud {
	
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne()
	@JoinColumn(name = "ciudadOrigen_Id")
	private Ciudad ciudadOrigen_Id;

	@ManyToOne()
	@JoinColumn(name = "ciudadDestino_Id")
	private Ciudad ciudadDestino_Id;

	private Date fechaSalida;
	
	private Date fechaRegreso;
	
	private Date fechaModificacion;

	@ManyToOne()
	@JoinColumn(name = "EstadoSolicitud_Id")
	private EstadoSolicitud estadoSolicitud_Id;
		

	@ManyToOne()
	@JoinColumn(name = "empleado_Id")
	private Empleado empleado;

	
	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public EstadoSolicitud getEstadoSolicitud_Id() {
		return estadoSolicitud_Id;
	}

	public void setEstadoSolicitud_Id(EstadoSolicitud estadoSolicitud_Id) {
		this.estadoSolicitud_Id = estadoSolicitud_Id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ciudad getCiudadOrigen_Id() {
		return ciudadOrigen_Id;
	}

	public void setCiudadOrigen_Id(Ciudad ciudadOrigen_Id) {
		this.ciudadOrigen_Id = ciudadOrigen_Id;
	}

	public Ciudad getCiudadDestino_Id() {
		return ciudadDestino_Id;
	}

	public void setCiudadDestino_Id(Ciudad ciudadDestino_Id) {
		this.ciudadDestino_Id = ciudadDestino_Id;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaRegreso() {
		return fechaRegreso;
	}

	public void setFechaRegreso(Date fechaRegreso) {
		this.fechaRegreso = fechaRegreso;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}	
	

}
