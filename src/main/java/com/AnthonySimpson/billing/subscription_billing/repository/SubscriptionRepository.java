package com.AnthonySimpson.billing.subscription_billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AnthonySimpson.billing.subscription_billing.domain.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    
}
