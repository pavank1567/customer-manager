package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Customer {
	@Id
	@SequenceGenerator(
			name="customer_id_sequence",
			sequenceName="customer_id_sequence",
			allocationSize=1
			)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="customer_id_squence"
			)
	private Integer id;
	private String name;
	private String email;
	private Integer age;
	
	public Customer(int id, String name, String email, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name, String email, Integer age) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + "]";
	}

	
}
