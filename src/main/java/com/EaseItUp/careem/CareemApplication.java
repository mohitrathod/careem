package com.EaseItUp.careem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.EaseItUp.careem.model.Customer;
import com.EaseItUp.careem.model.Order;
import com.EaseItUp.careem.model.TransportPackage;
import com.EaseItUp.careem.model.TransportRoute;
import com.EaseItUp.careem.model.blockChain.BlockChain;
import com.EaseItUp.careem.model.blockChain.BlockChainContainer;
import com.EaseItUp.careem.model.blockChain.ChainParties;
import com.EaseItUp.careem.repository.CustomerRepository;
import com.EaseItUp.careem.repository.OrderRepository;
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

	@Autowired
	private OrderRepository orderRepository;

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


	@RequestMapping(value = "/getOrder", method = RequestMethod.GET)
	@ResponseBody
	public Order getOrder() {
		return orderRepository.findByCustomer(repository.findByFirstName("Mohit"));
	}


	@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
	@ResponseBody
	public Order addOrder() {

		return createOrder();

	}

	private Order createOrder() {

		// find the customer
		Customer customer = repository.findByFirstName("Mohit") ;

		Order order = new Order();
		order.customer = customer;

		List<TransportPackage> transportPackages = new ArrayList<>();

		TransportPackage transportPackage = new TransportPackage();
		transportPackage.dateDelivered = new Date();
		transportPackage.datePickup = new Date();
		transportPackage.contentType = "MAX_TYPE_2";
		transportPackage.name = "phone2";
		transportPackage.qty = 1;
		transportPackage.shape = "100 x 20 x 30";

		createLoctions(transportPackage);
		
		transportPackages.add(transportPackage);
		order.transportPackage = transportPackages;

		
		
		workOnBlockChain(order);

		return orderRepository.save(order);


	}

	private void createLoctions(TransportPackage transportPackage) {

		transportPackage.transportRoute = new TransportRoute();
		transportPackage.transportRoute.fromX = 1.1;
		transportPackage.transportRoute.fromY = 1.1;
		transportPackage.transportRoute.toX = 5.5;
		transportPackage.transportRoute.toY = 5.5;

	}

	private void workOnBlockChain(Order order) {

		order.blockChainContainer = new BlockChainContainer();
		order.blockChainContainer.blockChain = new BlockChain();
		order.blockChainContainer.blockChain.owner = order.customer.firstName;
		order.blockChainContainer.blockChain.blockChainTransection = BlockChain.BlockChainTransection.IN_TRANSIT;
		order.blockChainContainer.blockChain.transectionStart = new Date();
		order.blockChainContainer.blockChain.transectionFinish = new Date();


		order.blockChainContainer.chainParties = new ArrayList<>();

		{

			ChainParties captain = new ChainParties();
			captain.blockChain = order.blockChainContainer.blockChain;
			captain.coOwner = "captain1";
			captain.status = ChainParties.ChainPartieStatus.SUCCESS;

			captain.task = "transsport package from loc a to b";

			order.blockChainContainer.chainParties.add(captain);

		}

		{

			ChainParties captain = new ChainParties();
			captain.blockChain = order.blockChainContainer.blockChain;
			captain.coOwner = "captain2";
			captain.status = ChainParties.ChainPartieStatus.ONGOING;

			captain.task = "transsport package from loc b to c";

			order.blockChainContainer.chainParties.add(captain);

		}





	}


	public static void main(String[] args) {
		SpringApplication.run(CareemApplication.class, args);
	}
	
	
}
