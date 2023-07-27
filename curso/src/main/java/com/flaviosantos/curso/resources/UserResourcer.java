package com.flaviosantos.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flaviosantos.curso.entities.Usuario;

@RestController
@RequestMapping(value = "/users")
public class UserResourcer {
	
	@GetMapping
	public ResponseEntity<Usuario> findAll(){
		Usuario u = new Usuario(1L, "maria", "maria@gmail.com", "4002-8922", "123456");
		return ResponseEntity.ok().body(u);
	}
}
