package com.EaseItUp.careem.model;

import com.EaseItUp.careem.model.blockChain.BlockChainContainer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;

import java.util.List;

/**
 * Created by ermoh on 25-02-2017.
 */
public class Order {


    @Id
    public String id;

    public Customer customer;

    public List<TransportPackage> transportPackage;

    public BlockChainContainer blockChainContainer;

    public OrderStatus orderStatus = OrderStatus.IN_PROCESS;

    public enum OrderStatus {

        IN_PROCESS,
        COMPLETE

    }

}


