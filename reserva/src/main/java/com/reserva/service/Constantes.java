package com.reserva.service;

public class Constantes {
	
	public enum EnumEstadoSolictud {
		Autorizacion_Seguridad(1),
		Autorizacion_Jefe(2),
		Autorizacion_Gerencia(3),
		Aprobado(4),
		Rechazado(5);
		int precio;
		EnumEstadoSolictud(int  p){
			precio = p;
		}
	    public int  getValor() {
	        return precio;
	    }
	}
}

