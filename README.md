# Patient Management System

A **Spring Boot Microservices Application** for managing patient data and hospital operations, built with **Java 24** and modern backend development practices.

## Overview

The **Patient Management System** provides APIs for handling patient information including registration, updates, retrieval, and deletion. The system is designed with clean architecture principles, ensuring scalability and maintainability.

---

## Features

- **Patient CRUD Operations**  
  Register, update, view, and delete patient records.

- **Microservice-Oriented Design**  
  Built for modularity and independent service deployment.

- **Robust Exception Handling**  
  Global exception handlers and custom exceptions.

- **DTO & Entity Layer Separation**  
  Clean separation between REST API models and database entities.

- **Repository Layer with Spring Data JPA**  
  Simplifies data persistence and queries.

- **Validation**  
  Ensures input data integrity using `@Valid` annotations.

- **API Documentation via Swagger**  
  Interactive documentation available via Swagger UI.

---

## Tech Stack

| Technology         | Purpose                          |
|-------------------|----------------------------------|
| **Java 24**        | Programming Language            |
| **Spring Boot**    | Backend Framework               |
| **Spring Data JPA**| ORM & Data Layer Abstraction    |
| **MySQL**          | Database                        |
| **Lombok**         | Boilerplate Code Reduction      |
| **Swagger (OpenAPI)** | API Documentation           |
| **Docker**         | Containerization (Optional)     |

---


---

## API Endpoints

| Method | Endpoint                | Description                     |
|---------|-------------------------|---------------------------------|
| `POST`  | `/api/patients`         | Register new patient           |
| `GET`   | `/api/patients/{id}`    | Get patient by ID              |
| `GET`   | `/api/patients`         | List all patients              |
| `PUT`   | `/api/patients/{id}`    | Update patient details         |
| `DELETE`| `/api/patients/{id}`    | Delete patient record          |

> **Swagger UI** available at:  
> `http://localhost:8080/swagger-ui/index.html`

---

## How to Run

### Prerequisites

- **Java 24**
- **Maven 3.9+**
- **MySQL Database**



