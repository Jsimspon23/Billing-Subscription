package com.AnthonySimpson.billing.subscription_billing.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AnthonySimpson.billing.subscription_billing.domain.Subscription;
import com.AnthonySimpson.billing.subscription_billing.domain.SubscriptionStatus;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    List<Subscription> findByStatusAndNextBillingDateLessThanEqual(SubscriptionStatus status, LocalDate date);
}
