# Subscription Billing Application
A backend REST API built with Java, Spring Boot, Maven, and PostgreSQL that manages a subscription billing lifecycle including customer management, plan creation, subscription handling, invoice generation, and payment processing via Stripe.
## Tech Stack
- Java 21 / Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven
- Stripe API
## Getting Started
### Prerequisites
- Java 21
- PostgreSQL running locally
- Stripe API key
### Installation

1. Clone the repo
2. Configure your database credentials in application.properties
3. Add your Stripe API key to application.properties
4. Run with mvn spring-boot:run

## API Endpoints
### Customer
- GET     /customers         Get all customers
- GET     /customers/{id}    Get one customer
- POST    /customers         Create a customer
- PUT     /customers/{id}    Update a customer
- DELETE /customers/{id}    Delete a customer
### Plan
- GET    /plans    Get all plans
- POST   /plans    Create a plan
### Subscription
- GET    /subscriptions/{id}    Get a subscription
- POST   /subscriptions        Subscribe a customer to a plan
### Invoice
- GET    /invoices              Get all invoices
- GET    /invoices/{id}         Get one invoice
- GET    /invoices/customer/{id} Get all invoices for a customer
- POST   /invoices              Generate an invoice
- PUT    /invoices/{id}         Update an invoice
### Payment
- GET    /payments/{id}          Get a payment
- GET    /payments/customer/{id} Get all payments for a customer
- POST   /payments              Process a payment
