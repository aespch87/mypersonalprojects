package com.easypaymentgateway.videogamerentalsystem.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * @author Antonio Espinosa Chica
 * @version 1.0
 * @since 2019-09-06
 * 
 *        Clase encargada de guardar información acerca del cliente y de sus puntos
 *
 */

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Customer {
	
	@Id
	@NotNull
	private Long id;
	
	@NotNull
	@Length(min = 0, max = 50)
	private String name;
	
	@NotNull
	@Length(min = 0, max = 200)
	private String subName;
	
	private int loyaltyPoints;
	
	public Customer() {}
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the subName
	 */
	public String getSubName() {
		return subName;
	}

	/**
	 * @param subName the subName to set
	 */
	public void setSubName(String subName) {
		this.subName = subName;
	}

	/**
	 * @return the loyaltyPoints
	 */
	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	/**
	 * @param loyaltyPoints the loyaltyPoints to set
	 */
	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}
	
	
}
