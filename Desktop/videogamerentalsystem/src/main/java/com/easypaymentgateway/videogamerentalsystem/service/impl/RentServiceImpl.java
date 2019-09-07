package com.easypaymentgateway.videogamerentalsystem.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.easypaymentgateway.videogamerentalsystem.enums.TypeGame;
import com.easypaymentgateway.videogamerentalsystem.enums.TypePriceGame;
import com.easypaymentgateway.videogamerentalsystem.exception.RentException;
import com.easypaymentgateway.videogamerentalsystem.model.Customer;
import com.easypaymentgateway.videogamerentalsystem.model.Game;
import com.easypaymentgateway.videogamerentalsystem.model.Rent;
import com.easypaymentgateway.videogamerentalsystem.service.RentService;

/**
 * @author Antonio Espinosa Chica
 * @version 1.0
 * @since 2019-09-06
 * 
 *        Clase encargada de implementar las operaciones relacionadas con la 
 *        clase Rent.
 *
 */
@Service
public class RentServiceImpl implements RentService{

	@Override
	public List<Rent> rentAGames(List<String> namesGames, int numOfDays) throws RentException {
		
		List<Game> games = new ArrayList<Game>(); //Recuperamos el/los videojuego/s de BBDD
		List<Rent> listRent = new ArrayList<Rent>();
		Rent rent = new Rent();
		
		Customer customer = new Customer(); // Aquí se recuperaría el usuario de BBDD
		
		int loyaltyPoints = 0;
		
		float priceOfGame = 0;
		
		for(Game game : games) {
			
			priceOfGame += this.calculatePriceOfGame(game.getType(), numOfDays);
			
			//Calculamos los puntos dependiendo del tipo de videojuego
			loyaltyPoints += this.calculateLoyaltyPoints(game.getType());
			
			rent.setPrice(priceOfGame);
			rent.setDaysOfRent(numOfDays);
			game.setAvailable(Boolean.FALSE);
			rent.setGame(game);
			rent.setCustomer(customer);
			
			listRent.add(rent);
		}
		
		
		customer.setLoyaltyPoints(loyaltyPoints);
		
		
		return listRent;
	}

	@Override
	public float returnAGame(String nameGame) throws RentException {
		
		Rent rent = new Rent(); //Implementar para obtener el alquiler de este videojuego por BBDD

		int days = 0;
		float priceExtraDays = (float) 0.0;
		
		if(!rent.getDateOfRent().equals(Calendar.getInstance())) {
			
			days = (int) ((Calendar.getInstance().getTime().getTime()-rent.getDateOfRenturnRent().getTime())/86400000);
			this.calculatePriceOfGame(rent.getGame().getType(), days);
		}
		
		rent.setPrice(rent.getPrice() + priceExtraDays);
		rent.setDaysOfRent(rent.getDaysOfRent() + days);
		
		
		rent.getGame().setAvailable(Boolean.TRUE); // Al guardar el objeto Rent, se haría con el objeto Game en cascada
		
		return priceExtraDays;
	}
	
	/**
	 * 
	 * Método que calcula el precio de un videojuego en función de su tipo y el número
	 * de días que vaya a ser alquilado.
	 * @param typeOfGame
	 * @param numOfDays
	 * @return precio final del videojuego
	 * @throws RentException
	 */
	private float calculatePriceOfGame(String typeOfGame, int numOfDays) throws RentException {
		
		float price = (float) 0.0;
		
		if(TypeGame.NEW_RELEASES.getName().equals(typeOfGame)) {
			
			price = TypePriceGame.PREMIUM_PRICE.getPrice() * numOfDays;
			
		}else if(TypeGame.STANDAR_GAMES.getName().equals(typeOfGame)) {

			if(numOfDays > 3) {
				
				price = TypePriceGame.BASIC_PRICE.getPrice();
				price += TypePriceGame.BASIC_PRICE.getPrice() * numOfDays - 3;
			}else {
				
				price = TypePriceGame.BASIC_PRICE.getPrice() * numOfDays;
			}
			 
		}else if(TypeGame.CLASSIC_GAME.getName().equals(typeOfGame)) {
			
			if(numOfDays > 5) {
				
				price = TypePriceGame.BASIC_PRICE.getPrice();
				price += TypePriceGame.BASIC_PRICE.getPrice() * numOfDays - 5;
			}else {
				
				price = TypePriceGame.BASIC_PRICE.getPrice() * numOfDays;
			}
		}else {
			
			throw new RentException(
					new StringBuilder("No existe el tipo de videojuego: ").append(typeOfGame).toString());
		}
		
		return price;
	}
	
	/**
	 * 
	 * Método para calcular los puntos conseguidos por un usuario al alquilar un videojuego
	 * @param typeOfGame
	 * @return puntos conseguidos por alquilar un tipo de videojuego
	 * @throws RentException
	 */
	private int calculateLoyaltyPoints(String typeOfGame) throws RentException {
		
		int loyaltyPoints = 0;
		
		if(TypeGame.NEW_RELEASES.getName().equals(typeOfGame)) {
			
			loyaltyPoints = 2;
		}else if(TypeGame.CLASSIC_GAME.getName().equals(typeOfGame) || TypeGame.STANDAR_GAMES.getName().equals(typeOfGame)) {
		
				loyaltyPoints = 1;
		}else{
				
				throw new RentException(
						new StringBuilder("No existe el tipo de videojuego: ").append(typeOfGame).toString());
		}
		
		return loyaltyPoints;
	}
}
