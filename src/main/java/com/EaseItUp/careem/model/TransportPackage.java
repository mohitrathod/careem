package com.EaseItUp.careem.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ermoh on 25-02-2017.
 */
public class TransportPackage {


    @Id
    public String id;

    public String name;

    public String shape;

    public String weight;

    public String contentType;

    public int qty;

    public Date datePickup;

    public Date dateDelivered;

    public Order order;

    public TransportRoute transportRoute;

}
