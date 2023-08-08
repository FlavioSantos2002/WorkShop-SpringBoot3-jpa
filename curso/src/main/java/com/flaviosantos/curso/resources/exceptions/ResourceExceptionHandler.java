package com.flaviosantos.curso.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.flaviosantos.curso.servicies.exceptions.ResouceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResouceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResouceNotFoundException e, HttpServletRequest r){
		
		String error = "resouce not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), r.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
