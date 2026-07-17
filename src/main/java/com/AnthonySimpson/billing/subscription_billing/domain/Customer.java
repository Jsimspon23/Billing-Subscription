package com.AnthonySimpson.billing.subscription_billing.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String  stripeCustomerId;
    @Column(unique = true)
    String email;
    LocalDateTime createdAt;
}
