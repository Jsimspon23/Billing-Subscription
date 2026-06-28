package com.AnthonySimpson.billing.subscription_billing.service;

import org.springframework.stereotype.Service;

import com.AnthonySimpson.billing.subscription_billing.domain.Plan;
import com.AnthonySimpson.billing.subscription_billing.repository.PlanRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class PlanService {
    
    private final PlanRepository planRepository;

    public Plan createPlan(Plan plan) {

        return planRepository.save(plan);
    }

    public Plan findById(Long id) {
        return planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan not found"));
    }
    
}
