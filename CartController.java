package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
	@Autowired
	   private CartService service;
	   
		//Retrieval
		@GetMapping("/carts")
		public List<Cart>list()
		{
			return service.listAll();
		}
		//Retrieve by Id
		@GetMapping("/carts/{id}")
		public ResponseEntity<Cart>get(@PathVariable Integer id)
		{
			try{
				Cart cart=service.get(id);
				return new ResponseEntity<Cart>(cart,HttpStatus.OK);
			}
		    catch(Exception e)
			{
				return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
			}
		}
		//Create 
		@PostMapping("/carts")
		public void add(@RequestBody Cart cart)
		{
			service.save(cart);
		}
		//Update
		@PutMapping("/carts/{id}")
		public ResponseEntity<?> update(@RequestBody Cart cart,@PathVariable Integer id)
		{
			try{
				Cart existCart =service.get(id);
				service.save(cart);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		    catch (NoSuchElementException e)
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		@DeleteMapping("/carts/{id}")
		public void delete(@PathVariable Integer id)
		{
			service.delete(id);
		}
}
