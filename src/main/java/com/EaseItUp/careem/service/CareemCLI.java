package com.EaseItUp.careem.service;

import com.EaseItUp.careem.CareemApplication;
import com.EaseItUp.careem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ermoh on 25-02-2017.
 */
@EnableAutoConfiguration
@SpringBootApplication
public class CareemCLI {


    @Autowired
    private CustomerRepository repository;



    public static void main(String[] args) {
        SpringApplication.run(CareemApplication.class, args);
    }


}
