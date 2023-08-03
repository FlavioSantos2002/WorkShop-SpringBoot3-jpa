package com.flaviosantos.curso.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flaviosantos.curso.entities.Usuario;
import com.flaviosantos.curso.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
	}
	
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}
	
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
