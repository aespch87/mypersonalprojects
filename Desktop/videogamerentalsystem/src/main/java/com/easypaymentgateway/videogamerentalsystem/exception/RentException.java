package com.easypaymentgateway.videogamerentalsystem.exception;

/**
 * @author Antonio
 *
 */
public class RentException extends Exception{
	
	private static final long serialVersionUID = -1638824007374622299L;

	/**
	 * Constructor de UsuarioException
	 * 
	 * @param mensaje
	 */
	public RentException(String mensaje) {
		super(mensaje);
	}
}
