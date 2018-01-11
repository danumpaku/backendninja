package com.udemy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Clase para el manejo de excepciones. En caso de no existir se respondera con la pagina ubicada en templates/error/500.html
 */

@ControllerAdvice
public class ErrorsController {
	
	public static final String INTERNAL_SERVER_ERROR = "error/500";
	
	@ExceptionHandler(Exception.class)
	public String showInternalServerError (){
		return INTERNAL_SERVER_ERROR;
	}
	
}
