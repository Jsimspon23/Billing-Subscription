package com.AnthonySimpson.billing.subscription_billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AnthonySimpson.billing.subscription_billing.domain.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
}
