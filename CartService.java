package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartService {
	@Autowired
	private CartRepository repository;
	
	
	public List<Cart>listAll()
	{
	  return repository.findAll();
	  
	}
	
	public Cart get(Integer id)
	{
		return repository.findById(id).get();
	}
	public void save(Cart cart)
	{
		repository.save(cart);
	}
	public void delete(Integer id)
	{
		repository.deleteById(id);
	}
}
