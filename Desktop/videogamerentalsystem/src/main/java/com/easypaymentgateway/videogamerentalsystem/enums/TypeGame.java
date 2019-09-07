/**
 * 
 */
package com.easypaymentgateway.videogamerentalsystem.enums;

/**
 * @author Antonio Espinosa Chica
 * @version 1.0
 * @since 2019-09-06
 * 
 * Clase enumerada encargada de guardar información acerca de los tipos de juegos
 *
 */

public enum TypeGame {

	NEW_RELEASES ("New releases", "Price is premium price (4€) times number of days rented"),

    STANDAR_GAMES ("Standard games", "Price is basic price (3€) for the first 3 days and then basic price times the number of days over 3"),

    CLASSIC_GAME ("Classic game", "Price is basic price for the first 5 days and then basic price times the number of days over 5");
	
	/**
     * Constructor
     */ 
	TypeGame (String name, String description) { 

        this.name = name;

        this.description = description;

    }
	
    //Campos tipo constante   
    private final String name; //Nombre del tipo de juego
    private final String description; //Descripción del tipo de juego
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
    

}
