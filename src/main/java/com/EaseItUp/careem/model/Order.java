package com.EaseItUp.careem.model;

import com.EaseItUp.careem.model.blockChain.BlockChainContainer;
import org.springframework.data.annotation.Id;

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

}


