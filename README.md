# Patient Management System

A Spring Boot microservices project that demonstrates authenticated API access, synchronous gRPC communication, event-driven analytics, automated integration testing, and locally reproducible cloud infrastructure.

## Architecture

- **api-gateway** — external entry point and request routing
- **auth-service** — authentication and JWT-based access control
- **patient-service** — patient lifecycle APIs and business logic
- **billing-service** — billing capability exposed to the patient workflow through gRPC
- **analytics-service** — asynchronous processing of patient events through Kafka
- **integration-tests** — end-to-end verification across service boundaries
- **infrastructure** — local cloud resources and CloudFormation automation using LocalStack
- **api-requests / grpc-requests** — repeatable REST and gRPC request examples

## Request and event flow

1. Clients authenticate through the auth service.
2. Requests enter through the API gateway and are routed to the relevant service.
3. Patient workflows call the billing service through gRPC where a synchronous response is required.
4. Patient events are published to Kafka for asynchronous analytics processing.
5. Integration tests validate the system across API and service boundaries.

## Engineering focus

- Explicit service boundaries and independently testable components
- JWT authentication at the platform edge
- REST for client-facing APIs and gRPC for internal synchronous communication
- Kafka for decoupled, asynchronous processing
- Integration tests for cross-service behavior
- LocalStack and CloudFormation for repeatable local infrastructure
- API and gRPC request collections for manual verification

## Technology

Java, Spring Boot, Spring Data JPA, REST, gRPC, Kafka, JWT, Docker, LocalStack, CloudFormation, Maven, and integration testing.

## Run locally

The services have independent build and configuration files. Start required infrastructure first, then authentication, patient, billing, analytics, and gateway services. Use the checked-in request collections to verify REST and gRPC flows.

> Treat this repository as a portfolio reference implementation. Review each module's configuration for exact ports, credentials, and infrastructure dependencies.

## Author

[Saurav Daruka](https://www.linkedin.com/in/sauravdaruka/)
