package com.AnthonySimpson.billing.subscription_billing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnthonySimpson.billing.subscription_billing.domain.Subscription;
import com.AnthonySimpson.billing.subscription_billing.service.SubscriptionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor

public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/{customerId}/{planId}")
    public Subscription createSubscription(@PathVariable Long  customerId, @PathVariable Long planId) {
        return subscriptionService.createSubscription(customerId, planId);
    }

    @GetMapping("/{id}")
    public Subscription getSubscriptionById(@PathVariable Long id) {
        return subscriptionService.findById(id);
    }

    @PutMapping("/{id}/cancel")
    public Subscription cancelSubscription(@PathVariable Long id) {
        return subscriptionService.cancelSubscription(id);

    }
    
}
