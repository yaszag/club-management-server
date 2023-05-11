# Sports Club Management

This is a Spring Boot application for managing sports clubs. It provides functionalities for club management, including data persistence, RESTful APIs, and security.

## Technologies Used

- Spring Boot
- Spring Data JPA
- Spring Web
- PostgreSQL
- Springfox Swagger
- JSON Web Token (JWT)
- Lombok

## Prerequisites

- Java 8
- PostgreSQL database (running on localhost:5432)
- Maven

## Getting Started

To run the application locally, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/club-management.git`
2. Navigate to the project directory: `cd club-management`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

The application will be accessible at `http://localhost:8080`.

## Configuration

The application uses the following configuration:

- Database URL: `jdbc:postgresql://localhost:5432/sportClubDB?createDatabaseIfNotExist=true`
- Database username: `yourUsername`
- Database password: `yourPassword`
- Hibernate dialect: `org.hibernate.dialect.PostgreSQL9Dialect`
- JWT token configuration:
  - Secret key: `secret-key`
  - Token expiration length: 24 hours (86400000 milliseconds)

## Usage

Once the application is running, you can use the provided RESTful APIs to manage sports clubs. The Swagger UI is available at `http://localhost:8080/swagger-ui.html`, where you can explore and test the APIs.

## Development

During development, you can use the following additional features:

- Automatic restart on code changes: `spring-boot-devtools`
- Lombok for simplified POJOs: `org.projectlombok`


