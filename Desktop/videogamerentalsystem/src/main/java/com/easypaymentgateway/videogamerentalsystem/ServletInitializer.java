package com.easypaymentgateway.videogamerentalsystem;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Antonio Espinosa Chica
 * @version 1.0
 * @since 2019-09-06
 * 
 *        Clase encargada de guardar información acerca del alquiler del
 *        videojuego
 *
 */

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(VideogamerentalsystemApplication.class);
	}

}
