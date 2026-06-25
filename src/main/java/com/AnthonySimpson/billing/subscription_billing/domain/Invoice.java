package com.AnthonySimpson.billing.subscription_billing.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Invoice {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "subscription_id")
    Subscription subscription;
    BigDecimal amount;
    String currency;
    @Enumerated(EnumType.STRING)
    InvoiceStatus status;
    LocalDateTime createdAt;
    LocalDate dueDate;
    @Column(nullable = true)
    LocalDateTime paidAt;


}
