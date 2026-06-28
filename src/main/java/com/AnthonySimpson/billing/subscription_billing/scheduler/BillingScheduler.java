package com.AnthonySimpson.billing.subscription_billing.scheduler;

import java.time.LocalDate;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.AnthonySimpson.billing.subscription_billing.domain.Subscription;
import com.AnthonySimpson.billing.subscription_billing.domain.SubscriptionStatus;
import com.AnthonySimpson.billing.subscription_billing.repository.SubscriptionRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BillingScheduler {

    private final SubscriptionRepository subscriptionRepository;

    @Scheduled(cron = "0 0 8 * * *")
    public void runDailyBilling() {
        List<Subscription> dueSubscriptions = subscriptionRepository.findByStatusAndNextBillingDateLessThanEqual(SubscriptionStatus.ACTIVE, LocalDate.now());

        for(Subscription subscription : dueSubscriptions) {
            System.out.println("Processing billing for subscription: " + subscription.getId());

            subscription.setNextBillingDate(subscription.getNextBillingDate().plusMonths(1));
            subscriptionRepository.save(subscription);
        }

    }
}
