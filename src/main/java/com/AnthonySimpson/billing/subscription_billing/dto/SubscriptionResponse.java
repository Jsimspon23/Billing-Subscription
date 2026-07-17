package com.AnthonySimpson.billing.subscription_billing.dto;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class SubscriptionResponse {
    
    String id;
    String  customer;
    String status;

    public static SubscriptionResponse fromStripe(com.stripe.model.Subscription stripeSubscription) {
        SubscriptionResponse response = new SubscriptionResponse();
        response.id = stripeSubscription.getId();
        response.status = stripeSubscription.getStatus();
        response.customer = stripeSubscription.getCustomer();
        return response;
    }


}
