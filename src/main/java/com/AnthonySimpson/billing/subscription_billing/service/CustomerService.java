package com.AnthonySimpson.billing.subscription_billing.service;

import org.springframework.stereotype.Service;

import com.AnthonySimpson.billing.subscription_billing.domain.Customer;
import com.AnthonySimpson.billing.subscription_billing.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        
        return customerRepository.save(customer);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
    

 }
    
