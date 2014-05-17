package com.reserva.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="empleado")
public class Empleado {
	
	@Id
	@GeneratedValue
	private Integer id;

	private Integer identificacion;

	private String nombre;
	
	private String apellido;
	
	private Date fechaModificacion;

	private String usuario;

	private String contrasena;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="empleado_id")
    private Set<EmpleadoPermiso> empleadoPermiso;	

	@Transient
    private List<EmpleadoPermiso> empleadoPermisoAll;	

    
	public List<EmpleadoPermiso> getEmpleadoPermisoAll() {
		return empleadoPermisoAll;
	}

	public void setEmpleadoPermisoAll(List<EmpleadoPermiso> empleadoPermisoAll) {
		this.empleadoPermisoAll = empleadoPermisoAll;
	}

	public Set<EmpleadoPermiso> getEmpleadoPermiso() {
		return empleadoPermiso;
	}

	public void setEmpleadoPermiso(Set<EmpleadoPermiso> empleadoPermiso) {
		this.empleadoPermiso = empleadoPermiso;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Integer identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	

}
