package com.easypaymentgateway.videogamerentalsystem.exception;

/**
 * @author Antonio Espinosa Chica
 * @version 1.0
 * @since 2019-09-06
 * 
 *        Clase encargada de recoger las excepciones de la clase Rent
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
