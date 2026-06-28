package com.AnthonySimpson.billing.subscription_billing.service;

import org.springframework.stereotype.Service;

import com.AnthonySimpson.billing.subscription_billing.domain.Payment;
import com.AnthonySimpson.billing.subscription_billing.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {

        return paymentRepository.save(payment);
    }

    public Payment findById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment Not Found "));
    }
}
