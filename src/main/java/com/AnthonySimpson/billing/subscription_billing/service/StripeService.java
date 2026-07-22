package com.AnthonySimpson.billing.subscription_billing.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import com.AnthonySimpson.billing.subscription_billing.repository.CustomerRepository;
import com.AnthonySimpson.billing.subscription_billing.domain.Customer;
import com.AnthonySimpson.billing.subscription_billing.dto.SubscriptionResponse;
import com.stripe.Stripe;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.SubscriptionCreateParams;
import com.stripe.param.SubscriptionListParams;
import com.stripe.exception.StripeException;
import com.stripe.param.CustomerUpdateParams;
import com.stripe.param.PaymentMethodAttachParams;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StripeService {

    final CustomerRepository customerRepository;
    
    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeApiKey;
    }

    public Customer createStripeCustomer(Customer customer) throws StripeException {
        CustomerCreateParams params = CustomerCreateParams.builder().setName(customer.getFirstName() + " " + customer.getLastName()).setEmail(customer.getEmail()).build();

        com.stripe.model.Customer stripeCustomer = com.stripe.model.Customer.create(params);

        customer.setStripeCustomerId(stripeCustomer.getId());
        return customerRepository.save(customer);
    }

    public SubscriptionResponse createSubscription(Customer customer) throws StripeException {
        if (customer.getStripeCustomerId() == null) {
            throw new IllegalStateException(" Customer has not been synced to Stripe yet.");
        }

        SubscriptionListParams listParams  =  SubscriptionListParams.builder().setCustomer(customer.getStripeCustomerId()).build();
        com.stripe.model.SubscriptionCollection subscriptions = com.stripe.model.Subscription.list(listParams);


        for(com.stripe.model.Subscription sub : subscriptions.getData()) {
             String status = sub.getStatus();
            if (status.equals("active") || status.equals("trialing")) {
                throw new IllegalStateException("Customer already has an active or trailing subcription.");
            }
        }

        SubscriptionCreateParams params = SubscriptionCreateParams.builder().setCustomer(customer.getStripeCustomerId()).addItem(SubscriptionCreateParams.Item.builder().setPrice("price_1TtwsgDpPqiqPEYCz1KfMqgv").build()).build();

        com.stripe.model.Subscription stripeSubscription = com.stripe.model.Subscription.create(params);
        return SubscriptionResponse.fromStripe(stripeSubscription);
    }

    public void attachPaymentMethod(Customer customer) throws StripeException {
        com.stripe.model.PaymentMethod paymentMethod = com.stripe.model.PaymentMethod.retrieve("pm_card_visa");

        PaymentMethodAttachParams attachParams = PaymentMethodAttachParams.builder().setCustomer(customer.getStripeCustomerId()).build();
        
        paymentMethod.attach(attachParams);

        CustomerUpdateParams updateParams = CustomerUpdateParams.builder().setInvoiceSettings(CustomerUpdateParams.InvoiceSettings.builder().setDefaultPaymentMethod(paymentMethod.getId()).build()).build();
        com.stripe.model.Customer stripeCustomer = com.stripe.model.Customer.retrieve(customer.getStripeCustomerId());
        stripeCustomer.update(updateParams);
    }
}
