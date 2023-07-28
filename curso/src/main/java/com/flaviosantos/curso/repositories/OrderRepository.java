package com.flaviosantos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flaviosantos.curso.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	
}
