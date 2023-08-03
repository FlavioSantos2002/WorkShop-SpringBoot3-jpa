package com.flaviosantos.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.flaviosantos.curso.entities.Category;
import com.flaviosantos.curso.entities.Order;
import com.flaviosantos.curso.entities.OrderItem;
import com.flaviosantos.curso.entities.Payment;
import com.flaviosantos.curso.entities.Product;
import com.flaviosantos.curso.entities.Usuario;
import com.flaviosantos.curso.entities.enums.OrderStatus;
import com.flaviosantos.curso.repositories.CategoryRepository;
import com.flaviosantos.curso.repositories.OrderItemRepository;
import com.flaviosantos.curso.repositories.OrderRepository;
import com.flaviosantos.curso.repositories.ProductRepository;
import com.flaviosantos.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");  
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2023-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2); 
		Order o3 = new Order(null, Instant.parse("2023-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPreco()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPreco()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPreco()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPreco()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2023-06-20T19:53:07Z"), o1);
		o1.setPaymant(pay1);
		
		orderRepository.save(o1);
		
	}
	
}
