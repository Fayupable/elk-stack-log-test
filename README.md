# ELK Stack Spring Boot Project

A Spring Boot application integrated with ELK (Elasticsearch, Logstash, Kibana) stack for centralized logging and
monitoring.

## Technologies

- Java 17+
- Spring Boot 3.4.3
- MySQL Database
- ELK Stack 8.11.1
    - Elasticsearch
    - Logstash
    - Kibana
- Maven
- Docker & Docker Compose

## Prerequisites

- JDK 17 or higher
- Docker and Docker Compose
- Maven
- MySQL Database

## Configuration

Here's the updated section with a note about configuring different databases:

```markdown
### Environment Variables

The following environment variables should be placed in a `.env` file in the project root:

```properties
MYSQL_URL= your_mysql_url
MYSQL_USER=your_username
MYSQL_PASSWORD=your_password
JWT_SECRET=your_jwt_secret
JWT_EXPIRATION_MS=set_jwt_expiration
```

Note: If you're using a different database system, please adjust the `MYSQL_URL` accordingly with your database
connection URL format. For example:

- PostgreSQL: `your_database_url`
- Oracle: `your_database_url`
- SQL Server: `your_database_url`

## Running the Application

1. Start the ELK stack:

```bash
docker-compose up -d
```

2. Build the application:

```bash
mvn clean package
```

3. Run the application:

```bash
mvn spring-boot:run
```

## Accessing Services

- Spring Boot Application: http://localhost:8080
- Elasticsearch: http://localhost:9200
- Kibana: http://localhost:5601
- Logstash TCP input: http://localhost:5001 (Note: While 5000 is the default port for Logstash TCP input, we're using
  port 5001 because port 5000 is already in use by macOS system services on my MacBook)

## Monitoring

### Spring Boot Actuator Endpoints

The following actuator endpoints are enabled:

- Health check: `/actuator/health`
- Metrics: `/actuator/metrics`
- Loggers: `/actuator/loggers`

### Log Pattern

Logs include trace and span IDs for distributed tracing:

```
LEVEL [elk-stack,traceId,spanId]
```

## API Documentation

API endpoints are prefixed with `/api/elk-stack/v1`

## Features

- Spring Security with JWT authentication
- JPA/Hibernate with MySQL
- Centralized logging with ELK stack
- Spring Boot Actuator for monitoring
- Structured logging pattern
- Docker containerization

## Project Structure

```
.
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   │       ├── application.yml
│   │       └── logback.xml
├── docker-compose.yml
├── logstash.conf
└── pom.xml
```

## Documentation
Documentation showing UI views and detailed log outputs are available in:
### Log
-[Loggin Examples](./LOGGIN_EXAMPLES.md)
### Images
-[Images](./IMAGES.md)

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request
