package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerRepo;
import com.example.demo.model.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private final CustomerRepo repo;
	
	public CustomerController(CustomerRepo repo) {
		super();
		this.repo = repo;
	}


	@GetMapping
	public List<Customer> getAllCustomers(){
		return repo.findAll();
	}
	
	@PostMapping
	public void addCustomer(@RequestBody Customer customer) {
		repo.save(customer);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Integer id) {
		
		repo.deleteById(id);
	}
	@PutMapping("/{id}")
	public void updateCustomer(@PathVariable Integer id,@RequestBody Customer customer) {
		Customer updateCustomer = repo.findById(id).orElseThrow();
		updateCustomer.setName(customer.getName());
		updateCustomer.setEmail(customer.getEmail());
		updateCustomer.setAge(customer.getAge());
		repo.save(updateCustomer);
	}
}
