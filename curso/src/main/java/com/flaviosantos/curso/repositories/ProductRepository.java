package com.flaviosantos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flaviosantos.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
}
