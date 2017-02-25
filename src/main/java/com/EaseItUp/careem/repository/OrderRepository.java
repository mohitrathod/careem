package com.EaseItUp.careem.repository;

import com.EaseItUp.careem.model.Customer;
import com.EaseItUp.careem.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ermoh on 25-02-2017.
 */
public interface OrderRepository extends MongoRepository<Order, String> {

    public Order findByCustomer(Customer customer);

}
