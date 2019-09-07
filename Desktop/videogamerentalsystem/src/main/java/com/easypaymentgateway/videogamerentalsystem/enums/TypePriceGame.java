package com.easypaymentgateway.videogamerentalsystem.enums;

/**
 * @author Antonio Espinosa Chica
 * @version 1.0
 * @since 2019-09-06
 * 
 * Clase encargada de guardar información acerca del videojuego
 *
 */
public enum TypePriceGame {

	PREMIUM_PRICE ("Premium price", 4),

    BASIC_PRICE ("Basic price", 3);
 

    //Campos tipo constante   
	//@Getter
    private final String name; //Nombre del tipo de precio del juego
	
	//@Getter
    private final float price; //Precio del juego

 

    /**
     * Constructor
     */ 
    TypePriceGame (String name, float price) { 

        this.name = name;

        this.price = price;

    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

}
