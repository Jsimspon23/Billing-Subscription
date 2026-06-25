package com.AnthonySimpson.billing.subscription_billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AnthonySimpson.billing.subscription_billing.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    
    
}
