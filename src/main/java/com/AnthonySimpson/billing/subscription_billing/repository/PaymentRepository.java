package com.AnthonySimpson.billing.subscription_billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AnthonySimpson.billing.subscription_billing.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}
