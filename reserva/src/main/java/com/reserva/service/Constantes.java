package com.reserva.service;

public class Constantes {
	
	public enum EnumEstadoSolictud {
		Pendiente(1),
		Autorizacion_Seguridad(2),
		Autorizacion_Jefe(3),
		Autorizacion_Gerencia(4),
		Aprobado(5),
		Rechazado(6);
		int precio;
		EnumEstadoSolictud(int  p){
			precio = p;
		}
	    public int  getValor() {
	        return precio;
	    }
	}
}

