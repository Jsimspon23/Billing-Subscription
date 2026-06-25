package com.AnthonySimpson.billing.subscription_billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AnthonySimpson.billing.subscription_billing.domain.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long>{
    
}
