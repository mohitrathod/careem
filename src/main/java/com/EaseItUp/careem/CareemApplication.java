package com.EaseItUp.careem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.EaseItUp.careem.model.Customer;
import com.EaseItUp.careem.model.Order;
import com.EaseItUp.careem.model.TransportPackage;
import com.EaseItUp.careem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class CareemApplication {

	@Autowired
	private CustomerRepository repository;

	@RequestMapping("/")
    @ResponseBody
    public List<Customer> home() {
		
		List<Customer> customerList = new ArrayList<>();
		
		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));
		repository.save(new Customer("Bob2", "Smith2"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
			customerList.add(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		
        return customerList;
    }



	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	@ResponseBody
	public Customer addCustomer() {

		Customer c = new Customer("Mohit", "Rathod");
		return repository.save(c);

	}


	@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
	@ResponseBody
	public Order addOrder() {

		// find the customer
		Customer customer = repository.findByFirstName("Mohit") ;

		Order order = new Order();
		order.customer = customer;

		List<TransportPackage> transportPackages = new ArrayList<>();

		TransportPackage transportPackage = new TransportPackage();
		transportPackage.dateDelivered = new Date();
		transportPackage.datePickup = new Date();
		transportPackage.contentType = "MAX_TYPE_2";
		transportPackage.contentType = "MAX_TYPE_2";

		return null;

	}


	public static void main(String[] args) {
		SpringApplication.run(CareemApplication.class, args);
	}
	
	
}
