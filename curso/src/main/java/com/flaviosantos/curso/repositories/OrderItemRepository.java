package com.flaviosantos.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flaviosantos.curso.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
	
}
