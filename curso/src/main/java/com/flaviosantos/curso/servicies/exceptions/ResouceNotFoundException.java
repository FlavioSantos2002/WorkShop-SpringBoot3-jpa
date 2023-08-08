package com.flaviosantos.curso.servicies.exceptions;

public class ResouceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResouceNotFoundException(Object id) {
		super("não foi possivel encontar o id: " + id);
	}

}
