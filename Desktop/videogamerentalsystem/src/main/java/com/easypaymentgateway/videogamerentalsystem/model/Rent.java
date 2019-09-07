package com.easypaymentgateway.videogamerentalsystem.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * @author Antonio Espinosa Chica
 * @version 1.0
 * @since 2019-09-06
 * 
 *        Clase encargada de guardar información acerca del alquiler del
 *        videojuego
 *
 */

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Rent {
	
	@Id
	@NotNull
	private Long id;

	private float price;
	
	@NotNull
	private Game game;
	
	@NotNull
	private Customer customer;
	
	private Date dateOfRent;
	
	private int daysOfRent;
	
	private Date dateOfRenturnRent;
	
	public Rent() {}
	
	/**
	 * @return the id
	 */							
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the daysOfRent
	 */
	public int getDaysOfRent() {
		return daysOfRent;
	}

	/**
	 * @param daysOfRent the daysOfRent to set
	 */
	public void setDaysOfRent(int daysOfRent) {
		this.daysOfRent = daysOfRent;
	}

	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * @return the dateOfRent
	 */
	public Date getDateOfRent() {
		return dateOfRent;
	}

	/**
	 * @param dateOfRent the dateOfRent to set
	 */
	public void setDateOfRent(Date dateOfRent) {
		this.dateOfRent = dateOfRent;
	}

	/**
	 * @return the dateOfRenturnRent
	 */
	public Date getDateOfRenturnRent() {
		return dateOfRenturnRent;
	}

	/**
	 * @param dateOfRenturnRent the dateOfRenturnRent to set
	 */
	public void setDateOfRenturnRent(Date dateOfRenturnRent) {
		this.dateOfRenturnRent = dateOfRenturnRent;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
