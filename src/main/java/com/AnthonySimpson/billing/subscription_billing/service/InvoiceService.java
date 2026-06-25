package com.AnthonySimpson.billing.subscription_billing.service;

import org.springframework.stereotype.Service;

import com.AnthonySimpson.billing.subscription_billing.domain.Invoice;
import com.AnthonySimpson.billing.subscription_billing.repository.InvoiceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public Invoice createInvoice(Invoice invoice) {

        return invoiceRepository.save(invoice);
    }
    
}
