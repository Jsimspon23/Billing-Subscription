package com.AnthonySimpson.billing.subscription_billing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnthonySimpson.billing.subscription_billing.domain.Customer;
import com.AnthonySimpson.billing.subscription_billing.dto.SubscriptionResponse;
import com.AnthonySimpson.billing.subscription_billing.service.CustomerService;
import com.AnthonySimpson.billing.subscription_billing.service.StripeService;
import com.stripe.exception.StripeException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor

public class CustomerController {

    private final CustomerService customerService;
    private final StripeService stripeService;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PostMapping("/{id}/stripe-sync")
    public Customer synctoStripe(@PathVariable Long id) throws StripeException {
        Customer customer = customerService.findById(id);
        return stripeService.createStripeCustomer(customer);
    }

    @PostMapping("/{id}/subscribe")
    public SubscriptionResponse subscribe(@PathVariable Long id) throws StripeException {
        Customer customer = customerService.findById(id);
        return stripeService.createSubscription(customer);
    }

    @PostMapping("/{id}/attach-payment-method")
    public void attachPaymentMethod(@PathVariable Long id) throws StripeException {
        Customer customer = customerService.findById(id);
        stripeService.attachPaymentMethod(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.findById(id);
    }

}
