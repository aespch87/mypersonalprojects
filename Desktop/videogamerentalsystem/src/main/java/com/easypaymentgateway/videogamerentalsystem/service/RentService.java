package com.easypaymentgateway.videogamerentalsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.easypaymentgateway.videogamerentalsystem.exception.RentException;
import com.easypaymentgateway.videogamerentalsystem.model.Rent;

/**
 * @author Antonio Espinosa Chica
 * @version 1.0
 * @since 2019-09-06
 * 
 *        Interface encargada de proporcionar las cabeceras de las operaciones 
 *        de la clase Rent.
 *
 */
@Service
public interface RentService {

	/**
	 * Método para alquilar uno o varios videojuegos, y calcular el precio en función del número de días y
	 * del tipo de juego.
	 * 
	 * @param nameGame
	 * @param numOfDays
	 * @return los alquiler/es de el/los juego/s
	 */
	public List<Rent> rentAGames(List<String> namesGames, int numOfDays) throws RentException;

	/**
	 * 
	 * Método para devolver un videojuego, y aplicar recargos en función del número de días de retraso
	 * en la devolución, si existiera.
	 * 
	 * @param nameGame
	 * @throws RentException 
	 * @return precio por recargo, si existiera
	 */
	public float returnAGame(String nameGame) throws RentException;
	
}
