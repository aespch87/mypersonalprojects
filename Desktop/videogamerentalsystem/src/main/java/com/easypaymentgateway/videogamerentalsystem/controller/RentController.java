package com.easypaymentgateway.videogamerentalsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easypaymentgateway.videogamerentalsystem.exception.RentException;
import com.easypaymentgateway.videogamerentalsystem.model.Rent;
import com.easypaymentgateway.videogamerentalsystem.service.RentService;

/**
 * @author Antonio Espinosa Chica
 * @version 1.0
 * @since 2019-09-06
 * 
 *        Clase utilizada como controlador del alquiler de videojuegos
 *
 */

@RestController
public class RentController {

	@Autowired
	private RentService rentService;
	
	Logger logger = LoggerFactory.getLogger(RentController.class);
	
	/**
	 * Método encargado de crear un usuairo
	 * @param usuairoDto
	 * @return El usuario creado
	 */
	@RequestMapping(value = "/crearUsuario", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public List<Rent> rentAGames(@PathVariable("namesGames") List<String> namesGames, @PathVariable("numOfDays") int numOfDays ) {
		
		List<Rent> listRent = new ArrayList<Rent>();
		
		try {
				
			listRent = rentService.rentAGames(namesGames, numOfDays);

		} catch (RentException e) {

			logger.error(e.getMessage());
		}
		
		return listRent;
	}
	
	/**
	 * Método encargado de crear un usuairo
	 * @param usuairoDto
	 * @return El usuario creado
	 */
	@RequestMapping(value = "/crearUsuario", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public float returnAGame(@PathVariable("nameGame") String nameGame ) {
		
		float price = (float) 0.0;
		
		try {
				
			price = rentService.returnAGame(nameGame);

		} catch (RentException e) {

			logger.error(e.getMessage());
		}
		
		return price;
	}
}
