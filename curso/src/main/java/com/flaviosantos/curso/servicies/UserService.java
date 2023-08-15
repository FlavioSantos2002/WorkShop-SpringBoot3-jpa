package com.flaviosantos.curso.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.flaviosantos.curso.entities.Usuario;
import com.flaviosantos.curso.repositories.UserRepository;
import com.flaviosantos.curso.servicies.exceptions.DatabaseExcepition;
import com.flaviosantos.curso.servicies.exceptions.ResouceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResouceNotFoundException(id));
	}
	
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}
	
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResouceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseExcepition(e.getMessage());
		}
		
	}
	
	public Usuario update(Long id, Usuario obj) {
		
		try {
			Usuario entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {

			throw new ResouceNotFoundException(id);
		}
		
	}

	private void updateData(Usuario entity, Usuario obj) {
		
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
