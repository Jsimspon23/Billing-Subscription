package com.AnthonySimpson.billing.subscription_billing.service;


import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.AnthonySimpson.billing.subscription_billing.domain.Customer;
import com.AnthonySimpson.billing.subscription_billing.domain.Plan;
import com.AnthonySimpson.billing.subscription_billing.domain.Subscription;
import com.AnthonySimpson.billing.subscription_billing.domain.SubscriptionStatus;
import com.AnthonySimpson.billing.subscription_billing.repository.CustomerRepository;
import com.AnthonySimpson.billing.subscription_billing.repository.PlanRepository;
import com.AnthonySimpson.billing.subscription_billing.repository.SubscriptionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class SubscriptionService {
    
    private final SubscriptionRepository subscriptionRepository;
    private final CustomerRepository customerRepository;
    private final PlanRepository planRepository;

    public Subscription createSubscription(Long customerId, Long planId) {
        
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        Plan plan = planRepository.findById(planId).orElseThrow(() -> new RuntimeException("Plan not found"));

        Subscription subscription = new Subscription();
        subscription.setCustomer(customer);
        subscription.setPlan(plan);
        subscription.setStatus(SubscriptionStatus.ACTIVE);
        subscription.setStartDate(LocalDate.now());
        subscription.setNextBillingDate(LocalDate.now().plusMonths(1));
        subscription.setFailedPaymentCount(0);

        return subscriptionRepository.save(subscription);
    }

    public Subscription cancelSubscription(Long subscriptionId) {
        
        Subscription subscription = subscriptionRepository.findById(subscriptionId).orElseThrow(() -> new RuntimeException("Subscription not found"));

        subscription.setStatus(SubscriptionStatus.CANCELLED);

        return subscriptionRepository.save(subscription);
    }
}
