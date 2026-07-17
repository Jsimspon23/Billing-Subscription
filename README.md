Subscription Billing Application
A backend REST API built with Java, Spring Boot, Maven, and PostgreSQL that manages a subscription billing lifecycle including customer management, plan creation, subscription handling, invoice generation, and payment processing via Stripe.
Tech Stack

Java 21 / Spring Boot
Spring Data JPA / Hibernate
PostgreSQL
Maven
Stripe API

Getting Started
Prerequisites

Java 21
PostgreSQL running locally
Stripe API key

Installation

Clone the repo
Configure your database credentials in application.properties
Add your Stripe API key to application.properties
Run with mvn spring-boot:run

API Endpoints
Customer
MethodEndpointDescriptionGET/customersGet all customersGET/customers/{id}Get one customerPOST/customersCreate a customerPUT/customers/{id}Update a customerDELETE/customers/{id}Delete a customer
Plan
MethodEndpointDescriptionGET/plansGet all plansPOST/plansCreate a plan
Subscription
MethodEndpointDescriptionGET/subscriptions/{id}Get a subscriptionPOST/subscriptionsSubscribe a customer to a plan
Invoice
MethodEndpointDescriptionGET/invoicesGet all invoicesGET/invoices/{id}Get one invoiceGET/invoices/customer/{id}Get all invoices for a customerPOST/invoicesGenerate an invoicePUT/invoices/{id}Update an invoice
Payment
MethodEndpointDescriptionGET/payments/{id}Get a paymentGET/payments/customer/{id}Get all payments for a customerPOST/paymentsProcess a payment
