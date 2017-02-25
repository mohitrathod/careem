package com.EaseItUp.careem.repository;


import com.EaseItUp.careem.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	 public Customer findByFirstName(String firstName);
	 public List<Customer> findByLastName(String lastName);

	 public List<Customer> findCustomer(String firstName, String lastName);

}
