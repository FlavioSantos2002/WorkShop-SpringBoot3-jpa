package com.flaviosantos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flaviosantos.curso.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{
	
	
}
