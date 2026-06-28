package com.AnthonySimpson.billing.subscription_billing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SubscriptionBillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionBillingApplication.class, args);
	}

}
