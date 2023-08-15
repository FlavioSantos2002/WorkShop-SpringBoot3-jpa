package com.flaviosantos.curso.servicies.exceptions;

public class DatabaseExcepition extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DatabaseExcepition(String msg) {
		super(msg);
	}
}
