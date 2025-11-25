\# User Management API



!\[Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge\&logo=java\&logoColor=white)

!\[Spring Boot](https://img.shields.io/badge/Spring\_Boot-3.3.5-6DB33F?style=for-the-badge\&logo=spring-boot\&logoColor=white)

!\[PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge\&logo=postgresql\&logoColor=white)

!\[Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge\&logo=docker\&logoColor=white)



A robust REST API for user management, developed with a focus on \*\*Security\*\*, \*\*Best Practices\*\*, and \*\*Testability\*\*. The project implements Stateless authentication via JWT, automatic documentation with Swagger, and a containerized environment.



\## 🚀 Technologies



\- \*\*Java 17\*\* \& \*\*Spring Boot 3.3.5\*\*

\- \*\*Spring Security 6\*\*: Stateless Authentication and Authorization.

\- \*\*JWT (Auth0)\*\*: Secure token generation and validation.

\- \*\*Spring Data JPA\*\*: Data persistence.

\- \*\*PostgreSQL\*\*: Main database (Docker Container).

\- \*\*H2 Database\*\*: In-memory database for fast integration testing.

\- \*\*Docker \& Docker Compose\*\*: Environment orchestration.

\- \*\*SpringDoc OpenAPI (Swagger)\*\*: Interactive API documentation.

\- \*\*JUnit 5 \& Mockito\*\*: Unit and Integration tests.



\## 🛠️ Architecture \& Patterns



The project follows the \*\*Layered Architecture\*\* pattern to ensure separation of concerns and maintainability:



\- `controller`: REST Layer (Input/Output).

\- `service`: Business Logic.

\- `repository`: Data Access.

\- `entity`: Database Models (JPA).

\- `security`: Security filters and JWT token configuration.

\- `dto`: Data Transfer Objects (Records).

\- `exception`: Global Error Handling.



\## ⚙️ How to Run



\### Prerequisites

\- Java 17+

\- Docker \& Docker Compose

\- Maven (Optional, the project includes the `./mvnw` wrapper)



\### 1. Clone the Repository

```bash

git clone \[https://github.com/your-username/user-management-api.git](https://github.com/your-username/user-management-api.git)

cd user-management-api

```



\### 2. Configure Environment Variables

For security reasons, the project uses environment variables. Create a ````.env```` file in the root directory or configure them in your IDE:

```bash

\# Database Configuration (Docker)

DB\_URL=jdbc:postgresql://localhost:5433/yourdb

DB\_USERNAME=youruser

DB\_PASSWORD=yourpassword



\# JWT Secret (Use a strong string)

JWT\_SECRET=your-secret-key-here

```



\### 3. Start Infrastructure (Docker)

This command starts the PostgreSQL database on port 5433 (to avoid conflicts with local installations).

```bash

docker-compose up -d

```



\### 4. Run the Application

```bash

./mvnw spring-boot:run

```



\## 📚 API Documentation (Swagger UI)

With the application running, access the interactive documentation to test the endpoints:



📍 http://localhost:8080/swagger-ui/index.html



\### 🔐 Authentication Flow in Swagger

1\. Create a user at POST /auth/register.



2\. Login at POST /auth/login to receive the JWT Token.



3\. Click the Authorize button (padlock icon) at the top of the page.



4\. Paste the token in the format: Bearer <your-token>.



5\. You can now access protected routes!



\## 🧪 Automated Tests

The project features a test suite configured to run isolated from the production database, using H2 in-memory.

```bash

\# Run all tests

./mvnw test

```

\#

\_Developed by Tiago Doriguelo\_

